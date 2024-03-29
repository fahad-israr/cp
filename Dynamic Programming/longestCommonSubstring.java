import java.lang.*;
import java.io.*;
import java.util.*;
/*
Given two strings. The task is to find the length of the longest common substring.

Example 1:

Input: S1 = "ABCDGH", S2 = "ACDGHR"
Output: 4
Explanation: The longest common substring
is "CDGH" which has length 4.
â€‹Example 2:

Input: S1 = "ABC", S2 "ACB"
Output: 1
Explanation: The longest common substrings
are "A", "B", "C" all having length 1.1

TESTCASE
-------------------
INPUT:
1
6 6
ABCDGH
ACDGHR

OUTPUT:
4
----------------------
1
17 60
KXCGMTMVVGFQQWSPD
JXZADDUKVLQPKUZJZHWSUTPCAFSYAIBJHAMMEGWBTPQELRNKBLDXGUZGCSEC

OUTPUT:
2
-----------------------------

 */

 
class longestCommonSubstring
 {  
    static int dp[][];
     static int max=-1;
	public static void main (String[] args)throws IOException
	 {      
	     
	     BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
	     int t=Integer.parseInt(obj.readLine());
	     while(t-->0){
	         StringTokenizer st=new StringTokenizer(obj.readLine());
	         int n=Integer.parseInt(st.nextToken());
	         int m=Integer.parseInt(st.nextToken());
	         String a=obj.readLine();
	         String b=obj.readLine();
	         dp=new int[n+1][m+1];
	         for(int i=0;i<=n;i++)
	         for(int j=0;j<=m;j++)
            if(i==0||j==0)dp[i][j]=0;
            else
	        dp[i][j]=-1;
	         max=-1;
	         System.out.println(lcs(a,b,n,m));
	         
	     }
	     
	 //code
	 }
	
	 static int lcs(String a,String b,int n,int m){
	    if(a.length()==0||b.length()==0) return 0;

	    int[][]dp = new int[n+1][m+1] ;

      int max = 0;
      for(int i=0;i<n+1;i++)
        for(int j=0;j<m+1;j++)
        { 
          if(i==0||j==0) 
            dp[i][j] = 0;
          else
          if(a.charAt(i-1)==b.charAt(j-1))
            {
             dp[i][j] = dp[i-1][j-1]+1;
             max = Math.max(dp[i][j],max);
            }
          else
            dp[i][j] = 0;
        }
	     
       return max;
	     
	 }
}