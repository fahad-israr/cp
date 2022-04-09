
class dfsUsingRecursion{
  public static void main(String[]args){
  
  //--- Create Graph---
  //.
  //.
  //--Call DFS 
  DFS(g,v)

  }

  // ===== Main DFS HERE ======
  static void DFSUtil(ArrayList<ArrayList<Integer>> g,boolean [] visited,int v){
    System.out.println(v);
    visited[v] = true;
    for(int i:g.get(v)){
      if(!visited[i])
        DFSUtil(g,visited,i);
    }
  }


  static void DFS(ArrayList<ArrayList<Integer>> g,int v){
    boolean [] visited = new boolean[v];

    for(int i=0;i<v;i++){
      if(!visited[i])
      DFSUtil(g,visited,i);
    }
  }//---DFS()
  
}