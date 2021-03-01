/*
Given a weighted directed graph with n nodes and m edges. Nodes are labeled from 0 to n-1, the task is to check if it contains a negative weight cycle or not.
Note: edges[i] is defined as u, v and weight.

TESTCASE:
------------
1
3 3
0 1 -1
1 2 -2
2 0 -3
Should Return : true
====================
1
3 3
0 1 -1
1 2 -2
2 0 3
Should Return : false
------------
*/
import java.util.*;
import java.lang.*;
import java.io.*;
class bellmanFordNegativeCycle
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            boolean ans = obj.isNegativeWeightCycle(n, edges,0); //Source = 0
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{   
    static final int INF = Integer.MAX_VALUE;
    
    public boolean isNegativeWeightCycle(int n, int[][] edges,int source)
    {
        /*for(int[]e:edges){
            for(int i:e)System.out.print(i+" ");
            System.out.println();
        }*/
        int[]dist = new int[n];
        Arrays.fill(dist,INF);
        
        dist[source] = 0;
        //Relax all edges V-1 times
        for(int i=0;i<n-1;i++)
        {
            for(int[]e:edges){
                int src = e[0];
                int dst = e[1];
                int weight = e[2];
                if(dist[src]!=INF && dist[src]+weight<dist[dst])
                    dist[dst] = dist[src]+weight;
            }
        }
        // Now we check if we can Relax one more time(this mean -ve Cycle)
        for(int i:dist)System.out.print(i+" ");
          System.out.println();
          
        for(int[]e:edges){
                int src = e[0];
                int dst = e[1];
                int weight = e[2];
                if(dist[src]!=INF && dist[src]+weight<dist[dst])
                    return true;
            }
          
          //Incase there is no negative cycle we'll print distances
          
        
        return false;
    }//---fx() ends here
}