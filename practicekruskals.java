void kruskals(Edge[]edges,int v){

for(Edge e:edges){
  int u  = e.u;
  int v = e.v;
  int parentU = findParents(u);
  int parentV = findParents(v);
  if(parentU == parentV)continue;
  else
  union(parentU,parentV);
}
} //---kruskals(args...) ends


int findParents(int v){
  while(parents[v]!=-1)
    v = parents[v];
  return v;
}

void union(int x,int y){
  parentX = findParents(x);
  parentY = findParents(y);
  parents[parentY] = parentX;
}