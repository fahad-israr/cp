// { Driver Code Starts
// Initial Template for Java

/*---------TEST----------- 
1
6
1 2 1 1 2 1 2 1 2 1 1 0 1 1 3 1 2 1 1 2 1 0 1 2 0 1 2 1 2 1 0 0 1 0 1 0

----------OUTPUT-----------
[5, 9, 9, 7, 7, 7]
----------------------------
*/
import java.util.*;
class dragon {
    static ArrayList<Integer> res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            res = new ArrayList<Integer>();
            boolean visited[][] =  new boolean[n][n];
            for(boolean[] i:visited)
              Arrays.fill(i,false);

            bfs(a,n-1,0,n,n,0,visited);
            System.out.println(res.toString());
        }
    }

    static void bfs(int[][]m,int i,int j,int height,int width,int steps,boolean[][]visited){
      //System.out.println(i+" "+j);
      if(m[i][j] == 3)
      {
        res.add(steps);
        return;
      }
      if(m[i][j]==2) return;

      visited[i][j] = true;

      

      int [] di = {1,-1,0,0};
      int [] dj = {0,0,1,-1};

      for(int k = 0;k<4;k++)
      {
        int nextI = i + di[k];
        int nextJ = j + dj[k];
        if(isValid(nextI,nextJ,height,width) && visited[nextI][nextJ  ] == false)
          bfs(m,nextI,nextJ,height,width,steps+1,visited);
      }
      visited[i][j]  = false;

    }

    static boolean isValid(int i,int j,int m,int n){
      if(i>=m||j>=n||i<0||j<0)
        return false;
      return true;
    }
}

