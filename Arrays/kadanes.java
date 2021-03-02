// KADANE's ALGORTIHM
import java.io.*;

class kadanes {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling maxSubarraySum() function
		    System.out.println(obj.maxSubarraySum(arr, n));
		}
	}
}

// } Driver Code Ends




class Solution{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int arr[], int n){
      
      int max = Integer.MIN_VALUE;

      int sum = 0;
      
      int curr = 0;

      for(int i=0;i<n;i++)
      {
        curr = curr + arr[i];
        if(curr<0)
          curr = 0;
        else
          max = Math.max(max,curr);
      } 
      return max;
    }//--- fx(...) ends

    
}