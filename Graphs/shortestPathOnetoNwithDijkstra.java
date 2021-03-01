// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class shortestPathOnetoNwithDijkstra
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minStep(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java
/*
Consider a directed graph whose vertices are numbered from 1 to n.
 There is an edge from a vertex i to a vertex j iff either j = i + 1 or j = 3 * i.
  The task is to find the minimum number of edges in a path in G from vertex 1 to vertex n.
 */
class Solution{
    static int minStep(int n){
        //=====Make Graph=====
        ArrrayList<ArrrayList<Integer>> adj = new ArrrayList<ArrrayList<Integer>>();
        for(int i=0;i<n;i++){
          adj.add(new ArrrayList<Integer>());
          for(int j=0;j<n;j++){
            if(j=i+1||(j+1)=3*(i+1))
            adj.get(i).add(j);
          }//---for(j...)
        }//--for(i...)
        //========Make Graph ENDS=====
        
        //===Lets find min edges between 0 and n-1 ===
        /*WE CAN Do Using BFS but lets try Doing using Dijkstra*/
    }//--fx
}
