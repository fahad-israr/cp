

import java.util.*;
class maze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            GfG g = new GfG();
            ArrayList<String> res = g.printPath(a, n);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
class GfG {

    static class cell{
        int x,y;
        cell(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    static ArrayList<String> ret; 
    /*Test case
    ----------------------
    N = 4, m[][] =    {{1, 0, 0, 0},
                       {1, 1, 0, 1}, 
                       {1, 1, 0, 0},
                       {0, 1, 1, 1}}
                       
         */
    public static ArrayList<String> printPath(int[][] m, int n) {
        // Your code here
       ret=new ArrayList<String>();
       boolean[][]visited=new boolean[n][n];
       if(m[n-1][n-1]==0)return ret;
       if(m[0][0]==1)
       bfs(m,new cell(0,0),n,"",visited); 
       else return ret;
       Collections.sort(ret);
       return ret;
    }
    static void bfs(int[][] m,cell curr,int n,String res,boolean[][]visited){
        int x=curr.x;
        int y=curr.y;    

        if(x==n-1&&y==n-1){ret.add(res);return;}
        visited[x][y]=true;

        if(x+1<n && m[x+1][y]==1&&!visited[x+1][y]){bfs(m,new cell(x+1,y),n,res+"D",cpy(visited,n));}
        if(x-1>=0&&(!visited[x-1][y])&&m[x-1][y]==1)bfs(m,new cell(x-1,y),n,res+"U",cpy(visited,n));
        if(y+1<n && m[x][y+1]==1&&!visited[x][y+1])bfs(m,new cell(x,y+1),n,res+"R",cpy(visited,n));
        if(y-1>=0&&(!visited[x][y-1])&&m[x][y-1]==1)bfs(m,new cell(x,y-1),n,res+"L",cpy(visited,n));
        
    }
    static boolean[][] cpy(boolean [][]a,int n){
        boolean b[][] = new boolean[n][n]; 
        for (int i=0; i<n; i++) 
            for(int j=0;j<n;j++)
             b[i][j] = a[i][j]; 
        return b;
    }
}
  /*Test case
    ----------------------
    N = 4, m[][] =    {{1, 0, 0, 0},
                       {1, 1, 0, 1}, 
                       {1, 1, 0, 0},
                       {0, 1, 1, 1}}
    INPUT
    --------
    4
    1 0 0 0 1 1 0 1 1 1 0 0 0 1 1 1                       
    OUTPUT
    --------
    DDRDRR DRDDRR
                       
         */