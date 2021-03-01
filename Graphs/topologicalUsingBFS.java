import java.io.*;
import java.util.*;
class topologicalUsingBFS{
  public static void main(String[]args){
    int[][] adj={{0,0,0,0,0,0},
                  {0,0,0,0,0,0},
                  {0,0,0,1,0,0},
                  {0,1,0,0,0,0},
                  {1,1,0,0,0,0},
                  {1,0,1,0,0,0}};
    int v = 6;
    ArrayList<Integer> res = topologicalSort(adj,v);
    System.out.println(res.toString());
  }// main(args..) ends here

  static ArrayList<Integer> topologicalSort(int[][]adj,int v){
    ArrayList<Integer> res = new ArrayList<Integer>(); 
    int[]in_degree=new int[v]; // stores number of incoming edges
    for(int i=0;i<v;i++)
      for(int j=0;j<v;j++)
        if(adj[i][j]==1)in_degree[j]++;
    
    Queue<Integer> q = new LinkedList<Integer>();
    for(int i=0;i<v;i++){
      if(in_degree[i]==0)q.add(i);
    }
    
    boolean visited[] = new boolean[v];
    Arrays.fill(visited,false);

    while(!q.isEmpty()){
      int curr = q.remove();
      visited[curr] = true;
      res.add(curr);
      for(int i=0;i<v;i++)
      {
        if(adj[curr][i] == 0) continue;
        in_degree[i]--;
        if(in_degree[i] == 0 && (!visited[i]))
           q.add(i);
      }
    }
    
    return res;

  }//fx()ends here


} 