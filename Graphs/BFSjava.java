import java.io.*;
import java.util.*;
class BFS{

  public static void main(String[]args)throws IOException{
    BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
    int v = Integer.parseInt(obj.readLine());
    int e = Integer.parseInt(obj.readLine());
    ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();

    while(e-->0){
      String [] edge = obj.readLine().split(" ");
      int src = Integer.parseInt(edge[0]);
      int dst = Integer.parseInt(edge[1]);
    }
    int src = Integer.parseInt(obj.readLine());
    System.out.println(bfs(g,v,0));
  }
 
  static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g,int v , int src){
    boolean visited[] = new boolean [v];
    ArrayList<Integer> res = new ArrayList<Integer>();

    Queue<Integer> q = new LinkedList<Integer>();

    q.add(src);
    visited[src] = true;
    while(!q.isEmpty()){
      int curr = q.poll(); //Can also write q.remove()
      res.add(curr);
      for(int i:g.get(curr)){
        if(!visited[i]){
          q.add(i); // Can also write q.offer(i)
          visited[i] = true ;
        }
      }
    }//---while() ends
    return res;
  }//---bfs
}//class