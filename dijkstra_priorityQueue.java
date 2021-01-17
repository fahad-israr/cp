// { Driver Code Starts
//Initial Template for Java
//----DIJKSTRA WITH PRIORITY QUEUE----
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

//----DIJKSTRA WITH PRIORITY QUEUE----

import java.util.*;
import java.io.*;
import java.lang.*;

class dijkstra_priorityQueue
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
      
       //---Init Dist to Infinite
       int []distance=new int[V];
       Arrays.fill(distance,Integer.MAX_VALUE);

       HashSet<Integer> included = new HashSet<Integer>();
       
       PriorityQueue<Node> pq = new PriorityQueue<Node>();
       pq.add(new Node(src,0));
       distance[src]=0;
       //update_distances(g,src,distance,included);
      
       while(included.size() != V){
           Node next = pq.poll();
           //distance[next.v] = Math.min(distance[next.v],next.d);
           included.add(next.v);
           update(g,next.v,distance,included,pq);
       }
        return distance;
    }
    static void update(ArrayList<ArrayList<Integer>> g,int u,int[]distance,HashSet<Integer> included,PriorityQueue<Node> pq){
      for(int i=0;i<g.get(u).size();i++){
        int wt = g.get(u).get(i);
        if(wt == 0)continue; //No connection exists
        if(included.contains(i))continue; //Already Included
        if(distance[u]+wt<distance[i])
          {
            distance[i] =  distance[u]+wt ; 
            pq.add(new Node(i,distance[i]));
            
          }
      }

    }//---fx()

}//---Solution class 

class Node implements Comparable<Node>{
  int v, d;
  Node(int v,int d){
    this.v = v;
    this.d = d;
  }
  @Override
  public int compareTo(Node b){
    return this.d - b.d;
  }
}