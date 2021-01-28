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
class longestIncreasingSubsequence{
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
    static int longestSubsequence(int n, int a[]){
        int lis[] = new int[n]; 
          int i,j,max = 0; 
  
          /* Initialize LIS values for all indexes */
           for ( i = 0; i < n; i++ ) 
              lis[i] = 1; 
  
           /* Compute optimized LIS values in  
              bottom up manner */
           for ( i = 1; i < n; i++ ) 
              for ( j = 0; j < i; j++ )  
                         if ( arr[i] > arr[j] &&  
                                  lis[i] < lis[j] + 1) 
                    lis[i] = lis[j] + 1; 
  
           /* Pick maximum of all LIS values */
           for ( i = 0; i < n; i++ ) 
              if ( max < lis[i] ) 
                 max = lis[i]; 
  
            return max; 

    }
} 