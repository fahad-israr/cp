//minimumOperations.java
/*
Given a number N. Find the minimum number of operations required to reach N starting from 0. You have 2 operations available:

Double the number
Add one to the number

Example 1:

Input:
N = 8
Output: 4
Explanation: 0 + 1 = 1, 1 + 1 = 2,
2 * 2 = 4, 4 * 2 = 8

â€‹Example 2:

Input: 
N = 7
Output: 5
Explanation: 0 + 1 = 1, 1 + 1 = 2,
1 + 2 = 3, 3 * 2 = 6, 6 + 1 = 7
 */

 // { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class minimumOperations
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperation(n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java


class Solution
{
    public int minOperation(int n)
    {
        //Simple if n divisble by 2 divide else subtract 1;
    }
}