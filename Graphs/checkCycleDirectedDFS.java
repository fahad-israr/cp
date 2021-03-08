// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class checkCycleDirectedDFS
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            for(int i = 0; i < nov+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if(new DetectCycle().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

/*
ArrayList<ArrayList<Integer>> adj: to represent graph containing 'v'
                                    vertices and edges between them
V: represent number of vertices
*/
class DetectCycle
{   static boolean visited[];
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V)
    {   
        /*for(ArrayList<Integer> ta:adj){
            for(int a:ta)
                System.out.print(a+"->");
            System.out.println();
        }*/
        //trying using DFS
        boolean[]visited=new boolean[V];
        boolean[]recstack=new boolean[V];
        boolean res = false;
        for(int i=0;i<V;i++)
        res = res|| hasCycle(adj,i,visited,recstack);
        return res;
    }
    static boolean hasCycle(ArrayList<ArrayList<Integer>> adj,int curr,boolean[]visited,boolean[]recstack){
        boolean a = false;
        if(recstack[curr])return true;
        if(visited[curr])return false;
        visited[curr] = true;
        recstack[curr] = true;
        
        for(int i:adj.get(curr)){
           a=a||hasCycle(adj,i,visited,recstack);
        }
        recstack[curr] = false;
        return a;
    }
    /*static class Pair{
        int v;
        ArrayList<Integer> parents=new ArrayList<Integer>();
        Pair(int v,ArrayList<Integer> previous_parents,int parent){
            this.v=v;
            for(int i:previous_parents)
            parents.add(i);
            parents.add(parent);
        }
    }
    // b is the starting vertex
    static boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int V,int source,boolean[]visited){
    Stack<Pair> stack=new Stack<Pair>();
    //ArrayList<Integer> popped =new ArrayList<Integer>();
    if(!visited[source])
    stack.push(new Pair(source,new ArrayList<Integer>(),-1));
    while(!stack.isEmpty()){
    Pair s=stack.pop();
    
        //System.out.println("vooola");
        for(int i:adj.get(s.v)){
            if(s.parents.contains(i))return true;
            if(!(visited[i]))stack.push(new Pair(i,s.parents,s.v));
        }
        visited[s.v]=true;
      
    }
    for(int i=0;i<V;i++)
      if(!(visited[i]))return hasCycle(adj,V,i,visited);
    return false;
    }// hasCycle function Ends here
    */
}