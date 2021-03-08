// https://leetcode.com/problems/triangle/

class Solution {
    private static final int INFINITY = Integer.MAX_VALUE ;
    
    static Integer [][] dp; 
    
    public int minimumTotal(List<List<Integer>> triangle) {
        
        dp = new Integer[triangle.size()+1][triangle.size()+1];
        
        return solve(triangle,0,0);
    }

    private int solve(List<List<Integer>> triangle , int row , int column){
        
        if(column >= triangle.get(row).size()) return INFINITY;
            
        if(row == triangle.size()-1) return triangle.get(row).get(column);
        
        if(dp[row][column]!=null) return dp[row][column];
        
        return dp[row][column] = triangle.get(row).get(column) + Math.min(solve(triangle,row+1,column),solve(triangle,row+1,column+1));
        
    }
    
    
} 