// { Driver Code Starts
// Initial Template for Java

/*---------TEST----------- 
1
4
1 0 0 0 1 1 0 1 1 1 0 0 0 1 1 1

----------OUTPUT-----------
DDRDRR DRDDRR
----------------------------
*/
import java.util.*;
class RatinaMaze {
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
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class GfG {


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
       bfs(m,0,0,n,"",visited); 
       else return ret;
       Collections.sort(ret);
       return ret;
    }
    static void bfs(int[][] m,int x,int y,int n,String res,boolean[][]visited){
      if(x==n-1 && y==n-1) {ret.add(res);return;}
      
      if(x<0||x>=n||y<0||y>=n||m[x][y]==0||visited[x][y])return;


      visited[x][y] = true;

      bfs(m,x+1,y,n,res+'D',visited);

      bfs(m,x-1,y,n,res+'U',visited);

      bfs(m,x,y+1,n,res+'R',visited);

      bfs(m,x,y-1,n,res+'L',visited);

      visited[x][y]  = false;

      return;
    }
}