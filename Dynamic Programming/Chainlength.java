// { Driver Code Starts
/*
You are given N pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. You have to find the longest chain which can be formed from the given set of pairs. 
 

Example 1:

Input:
N = 5
P[] = {5  24 , 39 60 , 15 28 , 27 40 , 50 90}
Output: 3
Explanation: The given pairs are { {5, 24}, {39, 60},
{15, 28}, {27, 40}, {50, 90} },the longest chain that
can be formed is of length 3, and the chain is
{{5, 24}, {27, 40}, {50, 90}}

â€‹Example 2:

Input:
N = 2
P[] = {5 10 , 1 11}
Output: 1
Explanation:The max length chain possible is only of
length one.
 */
        
import java.util.*;
import java.lang.*;

class Pair
{
    int x;
    int y;
    
    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}

class Chainlength
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Pair pr[] = new Pair[n];
            int arr[] = new int[2*n];
            for(int i = 0; i < 2*n; i++)
            {
               arr[i] = sc.nextInt();
            }
            for(int i = 0, j = 0; i < 2*n-1 && j < n; i = i+2, j++)
            {
                pr[j] = new Pair(arr[i], arr[i+1]);
            }
            GfG g = new GfG();
            System.out.println(g.maxChainLength(pr, n));
        }
    }
}
// } Driver Code Ends


class CompareByFirst implements Comparator<Pair>
{
   public int compare(Pair a, Pair b)
    {
        return a.x - b.x;
    }
}
//===ANOTHER SOLUTION FROM LEETCODE
/*
class Solution:
    def findLongestChain(self, pairs):
        N = len(pairs)
        pairs.sort(key = lambda x: x[1])
        ans = 0
        cur = -math.inf
        for head, tail in pairs:
            if head > cur:
                cur = tail
                ans += 1
        return ans
*/
// ====SOLUTION ENDS

//=== MY SOLN BEGINS==
class GfG
{
    int maxChainLength(Pair arr[], int n)
    {
//==== Better Greedy Solution here : https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/225801/Proof-of-the-greedy-solution
       
       Arrays.sort(arr,new CompareByFirst());

       int[]res =  new int[n+1];
       Arrays.fill(res,1);
       int max = 1;
       for(int i=0;i<n;i++){
           for(int j=0;j<i;j++){
               if(arr[j].y<arr[i].x && res[j]+1>res[i])
                    res[i] = res[j]+1;
           }
           max = Math.max(max,res[i]);
       }
    
       return max;
    }
}

/*
public int findLongestChain(int[][] pairs) {
    Arrays.sort(pairs, (a,b) -> a[1] - b[1]);
    int count = 0, i = 0, n = pairs.length;
    while (i < n) {
        count++;
        int curEnd = pairs[i][1];
        while (i < n && pairs[i][0] <= curEnd) i++;
    }
    return count;
}
 */