// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }

    long nextLong() { return Long.parseLong(next()); }

    double nextDouble() { return Double.parseDouble(next()); }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

class stepsByKnight {
    public static void main(String[] args) {

        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            ;
            int knightpos[] = new int[2];
            knightpos[0] = sc.nextInt();
            ;
            knightpos[1] = sc.nextInt();
            ;
            int targetpos[] = new int[2];
            targetpos[0] = sc.nextInt();
            ;
            targetpos[1] = sc.nextInt();

            Solution T = new Solution();
            System.out.println(T.minStepToReachTarget(knightpos, targetpos, n));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java
/*===================================MAIN CODE HERE
TEST CASE:
1
6
4 5
1 1
----------------------------
OUTPUT: 3

 */
class Solution {
    static class Square{
      int x,y,d;
      Square(int x,int y,int d){
        this.x = x;
        this.y = y;
        this.d = d;
      }
    }
    // KnightPos : knight position coordinates
    // targetPos : target position coordinated
    // N : square matrix size
    public int minStepToReachTarget(int knightpos[], int targetpos[], int N) {
        //if we are already at target
        if(knightpos[0]==targetpos[0] && knightpos[1]== targetpos[1])return 0;

        //===Main code starts here===
        int[]xOpt = {2,2,-2,-2,1,-1,1,-1};
        int[]yOpt = {1,-1,1,-1,2,2,-2,-2};
        
        //We'll proceed with BFS method
        Queue<Square> q = new LinkedList<Square>();
        q.add(new Square(knightpos[0],knightpos[1],0));
        boolean visited[][] = new boolean [N+1][N+1];
        visited[knightpos[0]][knightpos[1]] = true;

        while(!q.isEmpty()){
            Square curr = q.poll();
            for(int i=0;i<8;i++){
                int nextX = curr.x + xOpt[i];
                int nextY = curr.y + yOpt[i];
                if(isValid(nextX,nextY,N)&&(!visited[nextX][nextY]))
                {   
                    if(nextX==targetpos[0] && nextY==targetpos[1]) return curr.d + 1;
                    visited[nextX][nextY]  = true;
                    q.add(new Square(nextX,nextY,curr.d+1));

                }
            }//---for(...)
        }//---while(...)
        return Integer.MAX_VALUE;
    }//---minStepToReachTarget()

    // Check if a coordinate is Valid or NOT
    static boolean isValid(int x,int y,int N){
      if(x<=0||y<=0||x>N||y>N) return false;
      else return true;
    }
}
