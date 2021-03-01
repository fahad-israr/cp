import java.io.*;
import java.util.*;
/*-------Detect Cycle: Union By Rank and Path Compression-----------------*/
/*----Runs in O(log(n)) 

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

class detectCycleUnionByRankAndPathCompression{

    static class Edge{
        int src,dst;
        Edge(int src,int dst){
            this.src=src;
            this.dst=dst;
        }
    }

    static class Subset{
        int parent;
        int rank;
        Subset(int parent,int rank){
            this.parent=parent;
            this.rank=rank;
        }
    }

    static class Graph{
        int v,e;
        Edge edges[];
        Subset subsets[];
        Graph(int v,int e){
            this.v=v;
            this.e=e;
            edges=new Edge[e];
            subsets=new Subset[v];
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

            Subset [] subsets = new Subset[v];
            for(int i=0;i<v;i++){
                subsets[i]=new Subset(i,0);
            }

            System.out.println(new detectCycleUnionByRankAndPathCompression().isCyclic(g.v,g.e,g.edges,subsets));
        }//Testcases Loop 

    }//----------------------main Ends here------------------

    boolean isCyclic(int v,int e,Edge[]edges,Subset[]subsets){
        for(int i=0;i<e;i++){
            int src=edges[i].src;
            int dst=edges[i].dst;
            int parent_src=find(subsets,src);
            int parent_dst=find(subsets,dst);
            if(parent_src==parent_dst)return true;
            
            //UNION
            //parents[dst]=src;

            //Calling Union fx for demo
            union(parent_dst,parent_src,subsets);
        }
        return false;
    }
    int find(Subset[]subsets,int i){
        if(subsets[i].parent!=i){
            subsets[i].parent=find(subsets,subsets[i].parent);
        }
        return subsets[i].parent;
    }
    void union(int x,int y,Subset[]subsets){
        int parent_x=find(subsets,x);
        int parent_y=find(subsets,y);
        if(subsets[parent_x].rank<subsets[parent_y].rank)
        subsets[parent_x].parent=parent_y;
        else
        if(subsets[parent_x].rank>subsets[parent_y].rank)
        subsets[parent_y].parent=parent_x;
        else
        {
          //---when ranks are equal---
          subsets[parent_y].parent=parent_x;
          subsets[parent_x].rank = subsets[parent_x].rank+1;
        }

    }
}// detectCycleUnionByRankAndPathCompression Class Ends here