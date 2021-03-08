// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

// ======== Main CODE ================
class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {
        boolean visited[] = new boolean [V];
        int[]parent = new int[V];
        
        for(int i=0;i<V;i++)
            parent[i] = i;
        
        // Handle Disjoint Graphs
        boolean res = false;
        for(int i=0;i<V;i++)
        if(!visited[i]) res = res || isCyclicUtil(g,V,visited,parent,i);
        return res;
    }
    
    static boolean isCyclicUtil(ArrayList<ArrayList<Integer>> g, int V,boolean[]visited,int[]parent,int curr)
    {
        visited[curr] = true;
        boolean res = false;
        for(int i:g.get(curr)){
            if(visited[i] && parent[curr]!=i)
                return true;
            // Otherwise
            if(!visited[i])
            {   
                parent[i]  = curr;
                res = res || isCyclicUtil(g,V,visited,parent,i);
            }
        }
        
        return res;
    }
       
    
      static class Vertex{
        int val,parent;
        Vertex(int val,int parent){
          this.val = val;
          this.parent = parent;
        }
      }
}




// ============== DRIVER CODE =======================

class checkCycleUndirectedDFS
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
                list.get(v).add(u);
            }
            if(new DetectCycle().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
ArrayList<ArrayList<Integer>> g: represent graph containing 'V' number of
                                    vertices and edges between them
V: represent number of vertices
*/
class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {
        boolean visited[] = new boolean [V];
        int[]parent = new int[V];
        
        for(int i=0;i<V;i++)
            parent[i] = i;
        
        // Handle Disjoint Graphs
        boolean res = false;
        for(int i=0;i<V;i++)
        if(!visited[i]) res = res || isCyclicUtil(g,V,visited,parent,i);
        return res;
    }
    
    static boolean isCyclicUtil(ArrayList<ArrayList<Integer>> g, int V,boolean[]visited,int[]parent,int curr)
    {
        visited[curr] = true;
        boolean res = false;
        for(int i:g.get(curr)){
            if(visited[i] && parent[curr]!=i)
                return true;
            // Otherwise
            if(!visited[i])
            {   
                parent[i]  = curr;
                res = res || isCyclicUtil(g,V,visited,parent,i);
            }
        }
        
        return res;
    }
       
    
      static class Vertex{
        int val,parent;
        Vertex(int val,int parent){
          this.val = val;
          this.parent = parent;
        }
      }
}