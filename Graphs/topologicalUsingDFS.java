import java.io.*;
import java.util.ArrayList;

class topologicalUsingDFS{
  static ArrayList<Integer> T;
  public static void main(String[]args)throws IOException{
    int[][] adj={{0,0,0,0,0,0},
                  {0,0,0,0,0,0},
                  {0,0,0,1,0,0},
                  {0,1,0,0,0,0},
                  {1,1,0,0,0,0},
                  {1,0,1,0,0,0}};
    T = new ArrayList<Integer>();
    int v=6; //6 vertices
    boolean visited[]=new boolean[v];

    /* Imagine a case when the starting vertex has no outgoing edges 
    then that'll be an issue. Thus loop over all the vertices. 
     Also works for disconnected Graphs.*/
     
    for(int i=0;i<v;i++){
      if(!visited[i])
      topologicalSort(i,v,adj,visited);
    }

    // Printing
    for(int i:T)
      System.out.println(i);

  }

  static void topologicalSort(int current_vertex,int v,int adj[][],boolean []visited){
      visited[current_vertex]=true;
      for(int i=0;i<v;i++)
        if(adj[current_vertex][i]==1 && (!visited[i]))
          topologicalSort(i,v,adj,visited);
        T.add(0,current_vertex);
        
      
  }// fx() ends here
}//class ends here