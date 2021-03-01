
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

/*
====TESTCASE====
3 3
0 1 -1
1 2 -2
2 0 3
============
 */

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class bellmanford {
    public static void main(String args[] ) throws Exception {
        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v = inp[0];
        int e = inp[1];
        Edge [] edges = new Edge[e];
        for(int i=0;i<e;i++){
            String[] inpstr = br.readLine().split(" "); 
           // int [] line = Arrays.stream(inpstr.split(" ")).mapToInt(Integer::parseInt).toArray();
            int src = Integer.parseInt(inpstr[0]);
            int dst = Integer.parseInt(inpstr[1]);
            int wt = Integer.parseInt(inpstr[2]);

            Edge tmp = new Edge(src,dst,wt);
            edges[i] = tmp;
        }
        int source = 0;
        int [] distance = new int[v];
        bellmanford(edges,v,e,source,distance);
        for(int i=1;i<v;i++)
        System.out.print(distance[i]+" ");
        // Write your code here
        System.out.println();

    }//---main() ends
    static void bellmanford(Edge[]edges , int v, int e ,int source, int[]distance){
      Arrays.fill(distance,1000000000);

      distance[source] = 0;
      for(int i=0;i<v-1;i++){
        for(Edge edge : edges){
          //System.out.println(edge.src+" "+edge.dst);
          distance[edge.dst] = Math.min(distance[edge.dst],distance[edge.src]+edge.wt);       
        }//---inner for ends here
      }//---outer for          
    }//---bellmanford ends here

    static class Edge{
      int src,dst,wt;
      Edge(int src,int dst,int wt){
          this.src = src;
          this.dst = dst;
          this.wt = wt;
      }  
    }//---Edge class Ends here
}
