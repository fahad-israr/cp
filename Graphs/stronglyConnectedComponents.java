// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;
// INCASE of Undirected Graph it'll be simple one. Think atleast once about it.

/*
Given a Directed Graph with V vertices and E edges, Find the number of strongly connected components in the graph.


TESTCASE:

INPUT:
-------
5 5
1 0
0 2
2 1
0 3
3 4

OUTPUT:
--------
3

*/

class stronglyConnectedComponents
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println("Number of Strongly Connected Components = "+ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java

// adj : Adjacency list representing the graph
// V: No of vertices


class Solution
{   /*
      // KOSARAJU ALGO Takes BFS so Complexity O(V+E)
      STEP_1 : Do the DFS and while returning push vertices into Stack
      STEP_2 : Reverse the Given Graph
      STEP_3 : Traverse the given Graph using DFS and every continuious Traversal will give you a Component
     */
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
      boolean[] visited = new boolean[V];
      Stack<Integer> stack = new Stack<Integer>();
      // Call the dfsModified(args...) Function to do DFS and push into stack while returning
      for(int i=0;i<V;i++)
        if(!visited[i]) dfsModified(adj,i,visited,stack);   //Incase Graph is Disconnected we'll call all components
      
      //Call reverse function
      ArrayList<ArrayList<Integer>> transpose = reverse(adj,V);

      //Now we PoP out each vertex from Stack and perform DFS 

      Arrays.fill(visited,false); //Reset Visited Array

      int components = 0;  //Number of Components
      //System.out.println(stack.contains(4));
      while(!stack.isEmpty()){

        int vertex = stack.pop();
        if(!visited[vertex]) {
          DFS(transpose,vertex,V,visited);
          components++;
          System.out.println(); //Newline
        }
         //Next component in New Line
      }
      System.out.println("---------");
      return components;
    }//kosaraju(args...)

    //===Traverses using DFS and pushes into stack while returning
    static void dfsModified(ArrayList<ArrayList<Integer>> adj,int curr,boolean[]visited,Stack<Integer> stack){
      visited[curr] = true;
      for(int i:adj.get(curr)){
        if(!visited[i]) dfsModified(adj,i,visited,stack);
      }
      stack.push(curr);  
    }//---DFS(args...)

    // Function that returns Reverse of a Graph
    static ArrayList<ArrayList<Integer>> reverse(ArrayList<ArrayList<Integer>> adj,int V){
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      
      //---Add Empty ArrayLists
      for(int i=0;i<V;i++)
        res.add(new ArrayList<Integer>());


      for(int i=0;i<V;i++){
        for(int j:adj.get(i)){
          res.get(j).add(i);   
        }
      }
      return res;
    }//---reverse(args...) ends

    //---Simple DFS function 
    static void DFS(ArrayList<ArrayList<Integer>> adj,int curr,int V,boolean[]visited){
      System.out.print(curr+" ");
      visited[curr] = true;
      for(int i:adj.get(curr))
        if(!visited[i]) DFS(adj,i,V,visited);
    }//---DFS(args...) ends

}//---Solution
