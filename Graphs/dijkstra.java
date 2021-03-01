// Dijkstra 
// Uses Adjacency Matrix

/*
#****************           ******************
#                                    # 
#                                    #   
#*************                       #    
#                                    # 
#                                    #  
#                            *****************


F 
A
H
A
D
|
I
S
R
A
R
*/

/*
-------Example Test CASE----------
## TESTCASE Number 1
--------------------

2
2
0 25 25 0
0
3
0 1 43 1 0 6 43 6 0
2

---OUTPUT---
0 25 
7 6 0 

--------------------------
---------------------------
## TESTCASE Number 2
--------------------
Input:
1
3
3 1 0 9 34 21 6 78 43
1

---OUTPUT---
9 0 21
---------------------------
*/
import java.util.*;
import java.io.*;
import java.lang.*;

class dijkstra
{
    static void printSolution(int dist[], int n)
    {
        for(int i = 0; i < n; i++)
            System.out.print(dist[i] + " ");
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        
        while(t > 0)
        {
            int V = Integer.parseInt(sc.next());;
            ArrayList<ArrayList<Integer>> list = new ArrayList<>(V);
            for(int i = 0;i < V; i++)
            {
                ArrayList<Integer> temp = new ArrayList<>(V);
                list.add(i, temp);
            }
            
            for(int i = 0; i < V; i++)
            {
                ArrayList<Integer> temp = list.get(i);
                for(int j = 0; j < V; j++)
                {
                    temp.add(Integer.parseInt(sc.next()));
                }
                list.add(temp);
            }
            int s = Integer.parseInt(sc.next());;
            Solution T = new Solution();
            int[] res = T.dijkstra(list, s, V);
            printSolution (res, V);
            System.out.println();
            t--;
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
*   g: vector of vectors which represents the graph
*   src: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution
{
    static int[] dijkstra(ArrayList<ArrayList<Integer>> g, int src, int V)
    {
       /*for(ArrayList<Integer> i:g){
           for(int j:i)
          System.out.print(j+" "); 
          System.out.println("\n------------------"); 
       }
        System.out.println("\n------TC ENDS-------");
       return new int[V];*/
       int []distance=new int[V];
       Arrays.fill(distance,Integer.MAX_VALUE);
       boolean included[]=new boolean[V];
       included[src]=true;
       distance[src]=0;
       update_distances(g,src,distance,included);
       // we have included src vertex but the remainng V-1 are pending so we loop for V-1 times.
       int count=V-1;
       while(count-- > 0){
           int next = next_vertice(distance,included,V);
           included[next]=true;
           update_distances(g,next,distance,included);
       }
        return distance;
    }
    static int next_vertice(int[]distance,boolean[]included,int v){
        int min=Integer.MAX_VALUE;
        int res=-1;
        for(int i=0;i<v;i++)
        {
            if((!included[i])&&distance[i]<=min)
            {min=distance[i];res=i;}
        }

        return res;
    }

    static void update_distances(ArrayList<ArrayList<Integer>> g,int v,int[]distance,boolean[]included){
        for(int i=0;i<g.get(v).size();i++){
            int distance_from_this_vertex = g.get(v).get(i);
            if(distance_from_this_vertex!=0)
            distance[i] = Math.min(distance[v]+distance_from_this_vertex,distance[i]);
       }
    }
   /* static allincluded(boolean included[]){
        for(boolean i:included)
        if()
    }*/
    
}