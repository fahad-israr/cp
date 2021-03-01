import java.util.*;
import java.io.*;
/*
A disjoint-set data structure is a data structure that keeps track of a set
of elements partitioned into a number of disjoint (non-overlapping) subsets.
A union-find algorithm is an algorithm that performs two useful operations 
on such a data structure:
Find: Determine which subset a particular element is in. 
This can be used for determining if two elements are in the same subset.
Union: Join two subsets into a single subset.
In this post, we will discuss the application of Disjoint Set Data Structure. The application is to check whether a given graph contains a cycle or not.
Union-Find Algorithm can be used to check whether an undirected graph contains cycle or not. Note that we have discussed an algorithm to detect cycle. This is another method based on Union-Find. This method assumes that the graph doesn’t contain any self-loops. 
We can keep track of the subsets in a 1D array, let’s call it parent[]. 

------RUNS IN O(n)------------

-----Test Case---------------
Case 1 :
1
3
2
0 1
1 2
*****OUTPUT=> false ****
----------------
Case 2 : 
1
3
3
0 1
1 2
0 2
*****OUTPUT=> true ****
----------------
*/
class detectCycleUnionFind{

    static class Edge{
        int src,dst;
        Edge(int src,int dst){
            this.src=src;
            this.dst=dst;
        }
    }
    static class Graph{
        int v,e;
        Edge[]edges;
        Graph(int v,int e){
            this.v=v;
            this.e=e;
            this.edges=new Edge[e];
        }
    }
    public static void main(String[]args)throws IOException{
        BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(obj.readLine());
        while(t-->0){
            int v=Integer.parseInt(obj.readLine());
            int e=Integer.parseInt(obj.readLine());
            Graph g=new Graph(v,e);

            for(int i=0;i<e;i++){
            int[] edge= Arrays.stream(obj.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            g.edges[i]=new Edge(edge[0],edge[1]);
            }
            int parents[]=new int[e+1];
            Arrays.fill(parents,-1);            
            System.out.println(new detectCycleUnionFind().isCyclic(g.edges,g.e,g.v,parents));
        }//Testcases Loop 
    }//Main function Ends

    boolean isCyclic(Edge[] edges,int e,int v,int[]parents){
        for(int i=0;i<e;i++){
            int src=edges[i].src;
            int dst=edges[i].dst;
            int parent_src=find(src,parents);
            int parent_dst=find(dst,parents);
            if(parent_src==parent_dst)return true;
            //UNION
            //parents[dst]=src;

            //Calling Union fx for demo
            union(parent_dst,parent_src,parents);
        }
        return false;
    }// -------isCyclic fx ends here

    int find(int i,int[]parents){
        if(parents[i]==-1)return i;
        return find(parents[i],parents);
    }
    
    void union(int x,int y,int[]parents){
        int parent_x=find(x,parents);
        int parent_y=find(y,parents);
        parents[parent_x]=parent_y;
    }


}//class ends