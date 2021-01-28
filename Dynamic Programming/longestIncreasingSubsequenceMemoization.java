// { Driver Code Starts
import java.io.*;
import java.util.*; 
/*
Longest Increasing Subsequence 
Medium Accuracy: 46.67% Submissions: 10639 Points: 4
Given an array of integers, find the length of the longest (strictly) increasing subsequence from the given array.

Example 1:

Input:
N = 16
A[]={0,8,4,12,2,10,6,14,1,9,5
     13,3,11,7,15}
Output: 6
Explanation:Longest increasing subsequence
0 2 6 9 13 15, which has length 6
Example 2:

Input:
N = 6
A[] = {5,8,3,7,9,1}
Output: 3
Explanation:Longest increasing subsequence
5 7 9, with length 3

=========TESTCASE===========
INPUT:
1
16
0 8 4 12 2 10 6 14 1 9 5 13 3 11 7 15

OUTPUT
6
------------------------------
INPUT:

 */
class longestIncreasingSubsequenceMemoization{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} // } Driver Code Ends


class Solution { 
    static Integer[][]dp;
    static int longestSubsequence(int size, int a[]){
      int max = -1;
      for(int i:a)if(i>max) max = i;

      dp = new Integer[size+1][max+2];
      return solve(a,size,max+1);
    }
    static int solve(int[]a,int n,int prev){
      if(n == 0)return 0;
      if(dp[n][prev]!=null) return dp[n][prev];
      if(a[n-1]<prev) return dp[n][prev] = Math.max(1+solve(a,n-1,a[n-1]),solve(a,n-1,prev));
      else return dp[n][prev] = solve(a,n-1,prev);
    }
} 