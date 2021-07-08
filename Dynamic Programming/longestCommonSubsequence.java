// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
/*
Given two sequences, find the length of longest subsequence present in both of them. Both the strings are of uppercase.

Example 1:

Input:
A = 6, B = 6
str1 = ABCDGH
str2 = AEDFHR
Output: 3
Explanation: LCS for input Sequences
ABCDGH and AEDFHR is ADH of
length 3.
Example 1:

Input:
A = 3, B = 2
str1 = ABC
str2 = AC
Output: 2
Explanation: LCS of "ABC" and "AC" is
"AC" of length 2.

 */
class longestCommonSubsequence {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    LCS obj = new LCS();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}// } Driver Code Ends


class LCS{
    
    static int[][]dp;
    static int lcs(int p, int q, String s1, String s2){
        //System.out.println(s1+"\n"+s2);
        dp = new int[p+1][q+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        return solve(s1,s2,p,q);

    }
    
    //=============== MEMOIZATION SOLUTION ===============
    static int solve(String s1,String s2,int m,int n){
      if(m==0||n==0) return 0;
      if(dp[m][n]!=-1) return dp[m][n];
      if(s1.charAt(m-1)==s2.charAt(n-1))
          return dp[m][n]  = 1 + solve(s1,s2,m-1,n-1);
      
      return dp[m][n] = Math.max(solve(s1,s2,m-1,n),solve(s1,s2,m,n-1));

    }

    // =============== Iterative Solution ===============

    static int solve(String s1,String s2,int m,int n){
         int[][]dp = new int[x+1][y+1];
        
        for(int i=0;i<x+1;i++)
            for(int j=0;j<y+1;j++){
                
                if(i==0||j==0)
                    dp[i][j] = 0;
                    
                else
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1] ;
    
                else{
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
            
        return dp[x][y] ;
    }
    
}