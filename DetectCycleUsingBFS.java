class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {
        boolean visited[] = new boolean [V];
        
        // Handle Disjoint Graphs
        boolean res = false;
        for(int i=0;i<V;i++)
        if(!visited[i]) res=res || isCyclicUtil(g,V,visited,i);
        return res;
    }
    
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
}