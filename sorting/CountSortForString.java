// { Driver Code Starts
import java.util.*;
import java.lang.*;

/* ================================================================
Given a string arr consisting of lowercase english letters, 
arrange all its letters in lexicographical order using Counting Sort.
====================================================================*/

class Solution
{
    //Function to arrange all letters of a string in lexicographical 
    //order using Counting Sort.
    public static String countSort(String arr)
    {
        char[] str = arr.toLowerCase().toCharArray();
        
        int min = 'a', max = 'z';
        
        int[] count  = new int[max-min+1];
        
        for(int i = 0; i< str.length; i++){
            count[str[i] - min]++;
        }
        
        for(int i = 1; i < count.length; i++){
            count[i] += count[i-1];
        }
        
        char[] ans = new char[str.length];
        
        for(int i = str.length -1; i >= 0; i--){
            int pos = count[str[i] - min] - 1;
            count[str[i] - min]--;
            //System.out.println(pos+" ~ "+i );
            ans[pos] = str[i];
        }
        
        return String.join(",", ans);
    }
}


class CountSort
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            String arr = "";
            arr = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.countSort(arr));
        }
    }
}
// } Driver Code Ends