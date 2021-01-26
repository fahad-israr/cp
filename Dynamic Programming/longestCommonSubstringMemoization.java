//Initial Template for Java

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


class longestCommonSubstringMemoization
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{

    Integer[][][] dp;
    int longestCommonSubstr(String S1, String S2, int n, int m){
        int l = Math.min(m,n); //Longest common substring's max possible length
        dp = new Integer[n+1][m+1][l+1];      
        //dp = new int[n+1][m+1];
        //for(int i=0;i<n+1;i++)for(int j=0;j<m+1;j++) dp[i][j] = -1;
        return LCSubStr(S1.toCharArray(),S2.toCharArray(),n,m,0);
        //return res == 0 ?1:res;
    }

    int LCSubStr(char[] X, char[] Y, int m, int n, int lcsCount) {
		if (m <= 0 || n <= 0)
			return lcsCount;
        //if(n==14)System.out.println("m: "+m+" n:"+n+" lcs:"+lcsCount);
		if (dp[m][n][lcsCount] != null)
			return dp[m][n][lcsCount];

		int lcsCount1=lcsCount;
		if (X[m - 1] == Y[n - 1])
			lcsCount1 = LCSubStr(X, Y, m - 1, n - 1, lcsCount + 1);

		int lcsCount2 = LCSubStr(X, Y, m, n - 1, 0);
		int lcsCount3 = LCSubStr(X, Y, m - 1, n, 0);

		return dp[m][n][lcsCount] = Math.max(lcsCount1, Math.max(lcsCount2, lcsCount3));
	}
}