import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SExpresssion {
    public static void main(String args[] ) throws Exception {
        //Reading Input from User
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[]input = br.readLine().toCharArray();
        
        char root=' '; //Stores Tree Root
        
        HashMap<Character,ArrayList<Character>> adj = new HashMap<Character,ArrayList<Character>>(); //Adjacency List
        HashMap<Character,Integer> CountParents = new HashMap<Character,Integer>(); //Number of parents of a Node
        HashMap<Character,Character> Parents = new HashMap<Character,Character>(); //Stores Parents

        char parent=' ';
        int index = 0;
        boolean E1=false,E2=false,E3=false,E4=false,E5=false;

        for (int i = 0; i < input.length; i++) {
        if (input[i] != '(' && input[i] != ')' && input[i] != ',' && input[i] != ' ') { //If input[i] is a node
            index++;
            if (index % 2 == 1) { //input[i] is a parent node. Store it for use in next iteration.
                
                //Input format check (E1)
                if (i - 1 >= 0 && input[i-1] != '(') {
                    E1 = true;
                } else if (i + 1 < input.length && input[i+1] != ',') {
                    E1 = true;;
                } 
                
                //Store parent for use in next iteration
                parent = input[i];
                if(!adj.containsKey(parent)) adj.put(parent,new ArrayList<Character>());
                
            } else { //input[i] is a child node. Check for input errors, then add to adjacency list if error checks pass
                
                //Input format check (E1)
                if (i - 1 >= 0 && input[i-1] != ',') {
                    E1 = true;
                } else if (i + 1 < input.length && input[i+1] != ')') {
                    E1 = true;
                } 
                
                //Duplicates check (E2)
                for (int j = 0;adj.containsKey(parent)&& j < adj.get(parent).size(); j++) { 
                    if (adj.get(parent).get(j) == input[i]) { //If there is already such a parent/child pair
                        E2 = true;
                    }
                } 
                //Binary tree violations check (E3)
                if (adj.containsKey(parent)&&adj.get(parent).size() == 2) { //If parent node already has 2 child
                    E3 = true;
                }
                
                //Multiple parents (tree contains cycle) check (E4)
                CountParents.put(input[i],CountParents.containsKey(input[i])?CountParents.get(input[i])+1:1);
                //numParents[parent];
                if(!CountParents.containsKey(parent))CountParents.put(parent,0);
                if (CountParents.get(input[i]) == 2) { //If node has 2 parents already
                    E4 = true;
                }
                // Using DSU to DETECT CYCLE

                char parent_1 = find(parent,Parents);
                char parent_2 = find(input[i],Parents);
                if(parent_1 == parent_2)
                   E4 = true;
                else
                  union(parent_1,parent_2,Parents);
                
                //Else (no violations), store to adjacency list
                adj.get(parent).add(input[i]);
                index = 0;
            }
        } else if (i - 1 <= 0 && input[i] == ' ') { //If input[i] is not a tree node, then perform input format check for consecutive spaces (E1)
            if (input[i] == ' ') {
                E1 = true;
            }
        }
    }
    
    //Multiple roots check (E5)
    int CountRoots = 0;
    for (char key : CountParents.keySet()) {
        if (CountParents.get(key) == 0) { //If node has no parents, it has to be a root
            root = key; //Set root of tree for S-Expression printout later
            CountRoots++;
            if (CountRoots == 2) { //If tree has more than 1 root
                E5 = true;
            }
        }
    }
    if(E1)System.out.println("E1");
    else
    if(E2)System.out.println("E2");
    else
    if(E3)System.out.println("E3");
    else
    if(E4)System.out.println("E4");
    else
    if(E5)System.out.println("E5");
    else
    //If the Tree is Error Free We Can Construct S-Expression Representation
    sExpression(adj,root);
    
    }

    //Find Parent
    static char find(char x,HashMap<Character,Character> Parents){
      if(Parents.containsKey(x))
        return find(Parents.get(x),Parents);
      return x;
    }
    // Take
    static void union(char parent,char child,HashMap<Character,Character> Parents){
      Parents.put(child,parent);
    }
    static void sExpression(HashMap<Character,ArrayList<Character>> adj,char curr){
        System.out.print("("+curr);
        int CountChild = adj.containsKey(curr)?adj.get(curr).size():0;
        if (CountChild == 1) {
            sExpression(adj, adj.get(curr).get(0));
        } else if (CountChild == 2) { 
            //Determine lexicographically smallest ordering
            if (adj.get(curr).get(0) < adj.get(curr).get(1)) { 
                sExpression(adj, adj.get(curr).get(0));
                sExpression(adj, adj.get(curr).get(1));
            } else {
                sExpression(adj, adj.get(curr).get(1));
                sExpression(adj, adj.get(curr).get(0));
            }
        }
        System.out.print(")");

    }
    
}