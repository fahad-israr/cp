// https://leetcode.com/problems/ones-and-zeroes

class Solution {
    static Integer[][][]dp;
    
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new Integer[m+1][n+1][strs.length+1];
        
        return solve(strs,m,n,strs.length-1);
    }
    private int solve(String[] strs, int m, int n,int i){
        if(m<0 || n<0) return Integer.MIN_VALUE;
        
        if(i<0)return 0;
        
        if(dp[m][n][i] != null) return dp[m][n][i];
        // Current String  = strs[i]
        int zeroes = 0 , ones = 0;
        
        for(char ch:strs[i].toCharArray()){
            if(ch == '0')
                zeroes++;
            else
                ones++;
        }
        
        return dp[m][n][i] = Math.max(1+solve(strs,m-zeroes,n-ones,i-1),solve(strs,m,n,i-1));
    }
}