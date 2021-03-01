import java.io.*;
import java.util.*;
class bfs{

  public static void main(String[]args)throws IOException{
    BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
    int v = Integer.parseInt(obj.readLine());
    int e = Integer.parseInt(obj.readLine());
    ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
    for(int i=0;i<v;i++)
    g.add(new ArrayList<Integer>());
    for(int i=0;i<2*e;i++){
      String [] edge = obj.readLine().split(" ");
      int src = Integer.parseInt(edge[0]);
      int dst = Integer.parseInt(edge[1]);
      
      g.get(src).add(dst);
    }
    System.out.println(g);
    int src = Integer.parseInt(obj.readLine());
    System.out.println("------BFS----------");
    System.out.println(bfs_al(g,v,src));
    System.out.println("------Check Cycle----------");
    System.out.println(isCyclicUndirected(g,v));
  }
  static ArrayList<Integer> bfs_al(ArrayList<ArrayList<Integer>> g,int v , int src){
    boolean visited[] = new boolean [v];
    ArrayList<Integer> res = new ArrayList<Integer>();

    Queue<Integer> q = new LinkedList<Integer>();

    q.add(src);
    visited[src] = true;
    while(!q.isEmpty()){
      int curr = q.poll();
      res.add(curr);
      for(int i:g.get(curr)){
        if(!visited[i]){visited[i]=true;q.add(i);}
      }
    }//---while() ends
    return res;
  }//---bfs

  //---detect cycle in undirected graph using bfs
  
  static boolean isCyclicUndirected(ArrayList<ArrayList<Integer>> g , int v){
        boolean visited[] = new boolean [v];
        
        // Handle Disjoint Graphs
        boolean res = false;
        for(int i=0;i<v;i++)
        if(!visited[i])
        res=res || isCyclicUtil(g,v,visited,i);

        return res;
  }//---isCyclic
      static boolean isCyclicUtil(ArrayList<ArrayList<Integer>> g, int V,boolean[]visited,int j)
    {
    
        Queue<Vertex> q = new LinkedList<Vertex>();
    
        q.add(new Vertex(j,-1));
        visited[j] = true;
        while(!q.isEmpty()){
          Vertex curr = q.poll();
          //res.add(curr);
          for(int i:g.get(curr.val)){
            if(visited[i] == true && curr.parent != i)return true;
            if(!visited[i]){q.add(new Vertex(i,curr.val));visited[i] = true;}
          }
        }//---while() ends
    
        return false;
       // add your code here
    }

  static class Vertex{
    int val,parent;
    Vertex(int val,int parent){
      this.val = val;
      this.parent = parent;
    }
  } 
}//class