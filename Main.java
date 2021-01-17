// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            ArrayList<ArrayList<Integer>> list = new ArrayList<>(N);

            // creating arraylist of arraylist
            for (int i = 0; i < N; i++) {
                ArrayList<Integer> temp = new ArrayList<>(M);
                list.add(i, temp);
            }

            // adding elements to the arraylist of arraylist
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int val = sc.nextInt();
                    list.get(i).add(j, val);
                }
            }

            System.out.println(new Islands().findIslands(list, N, M));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Islands {
    
    static class cell{
        int x,y;
        cell(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    
    // Function to find the number of island in the given list A
    // N, M: size of list row and column respectively
    static int findIslands(ArrayList<ArrayList<Integer>> A, int N, int M) {
    
    int c=0;
    boolean visited[][]=new boolean[N][M];
    for(int i=0;i<N;i++)for(int j=0;j<M;j++){
        if(visited[i][j]==false&&A.get(i).get(j)==1){bfs(A,i,j,N,M,visited);
        c++;}
    }
    return c;
    }
    static void bfs(ArrayList<ArrayList<Integer>> A,int sx,int sy, int N, int M,boolean [][]visited)
    {
        visited[sx][sy]=true;
        Queue<cell> q=new LinkedList<cell>();
        q.add(new cell(sx,sy));
        while(!q.isEmpty()){
            cell curr=q.remove(); //value being read here

            int []dx={1,1,0,-1,-1,-1,0,1};
            int []dy={0,1,1,1,0,-1,-1,-1};
            for(int i=0;i<8;i++){
                //cell nxt=new cell()
                int nx=curr.x+dx[i];
                int ny=curr.y+dy[i];
                
                 if(nx<N&&nx>=0&&ny>=0&&ny<M&&(!visited[nx][ny])&& A.get(nx).get(ny)==1){
                    q.add(new cell(nx,ny));
                    visited[nx][ny]=true; 
                    //System.out.println(nx+"  "+ny);
                 }
            }
        }
        
    }
}