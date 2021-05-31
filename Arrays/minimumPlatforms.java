// { Driver Code Starts
//Initial Template for Java
/*
Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms,

 

Example 1:

Input: N = 6 
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
Output: 3
Explanation: 
Minimum 3 platforms are required to 
safely arrive and depart all trains.
Example 2:

Input: N = 3
arr[] = {0900, 1100, 1235}
dep[] = {1000, 1200, 1240}
Output: 1
Explanation: Only 1 platform is required to 
safely manage the arrival and departure 
of all trains. 
 */
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}


// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static class Time implements Comparable<Time> {
        
        int t ;
        boolean arrival;
        
        Time(int t,boolean arrival){
            this.t = t;
            this.arrival = arrival;
        }
        
        public int compareTo(Time b){
            return this.t - b.t;
        }
    } // === Class Time ends
    
    
    static int findPlatform(int arr[], int dep[], int n)
    {
        ArrayList<Time> trains = new ArrayList<Time>();
        
        for(int i:arr) trains.add(new Time(i,true));
        for(int i:dep) trains.add(new Time(i,false));
        
        Collections.sort(trains);
        
        int curr = 0;
        int max = 0;
        
        for(Time i:trains){
            if(i.arrival)
                curr++;
            else
                curr--;
            max = Math.max(max , curr); 
        }
        return max;
    }
    
}

