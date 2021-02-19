/*
Minimum Cost Path 
------------
Hard Accuracy: 30.46% Submissions: 3432 Points: 8

Given a square grid of size N, each cell of which contains integer cost which represents a cost to traverse through that cell, we need to find a path from top left cell to bottom right cell by which the total cost incurred is minimum.
From the cell (i,j) we can go (i,j-1), (i, j+1), (i-1, j), (i+1, j). 

Note: It is assumed that negative cost cycles do not exist in the input matrix.
 

Example 1:

Input: grid = {{9,4,9,9},{6,7,6,4},
{8,3,3,7},{7,4,9,10}}
Output: 43
Explanation: The grid is-
9 4 9 9
6 7 6 4
8 3 3 7
7 4 9 10
The minimum cost is-
9 + 4 + 7 + 3 + 3 + 7 + 10 = 43.
Example 2:

Input: grid = {{4,4},{3,7}}
Output: 14
Explanation: The grid is-
4 4
3 7
The minimum cost is- 4 + 3 + 7 = 14.

========== TESTCASE =================

INPUT:
--------
1
4
9 4 9 9 
6 7 6 4 
8 3 3 7 
7 4 9 10 

OUTPUT:
--------
43
*/
// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class minCostPath
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution
{   
    static class Vertex implements Comparable<Vertex>{
        int x,y,cost;
        Vertex(int x,int y,int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int compareTo(Vertex b){
            return this.cost - b.cost;
        }
    }

    public int minimumCostPath(int[][] grid)
    {   int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[][] distance = new int[n][n];
        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
        
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        
        pq.add(new Vertex(0,0,grid[0][0]));

        while(!pq.isEmpty()){
            Vertex curr = pq.poll();
            if(visited[curr.x][curr.y] )continue;
            visited[curr.x][curr.y] = true;
            distance[curr.x][curr.y] = curr.cost;
            for(int k=0;k<4;k++){
                if(isValid(curr.x+dx[k],curr.y+dy[k],n) &&  !visited[curr.x+dx[k]][curr.y+dy[k]] )
                pq.add(new Vertex(curr.x+dx[k],curr.y+dy[k],curr.cost+grid[curr.x+dx[k]][curr.y+dy[k]]));
            }    
        }
        return distance[n-1][n-1];
    }
    private boolean isValid(int x,int y,int n){
        
        if(x>=n||y>=n||x<0||y<0) return false;
        
        return true;
    }

}