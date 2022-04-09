// { Driver Code Starts


  import java.util.*;
  import java.lang.*;
  import java.io.*;
  class Test
  {
      public static void main(String[] args) throws IOException
      {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int T = Integer.parseInt(br.readLine().trim());
          while(T-->0)
          {
              int n = Integer.parseInt(br.readLine().trim());
              int[] matrix = new int[n];
              
              String[] S = br.readLine().trim().split(" ");
              for(int i = 0; i < n; i++){
              matrix[i] = Integer.parseInt(S[i]);
              }

              Solution ob = new Solution();
              ob.solve(matrix);
              
          }
      }
  }
  // } Driver Code Ends
  
  
  
  
  class Solution
  {   
    public void solve(int[] arr){
        
    int n = arr.length;

    int i = 0, j = 0, k = n - 1;



    while(i <= k){

        if(arr[i] == 1){
            i++;
        } else if(arr[i] == 2){
            swap(arr, i, k);
            k--;
        } else {
            swap(arr, i, j);
            i++;
            j++;
        }

    }


    System.out.println(Arrays.toString(arr));

    }

    static void swap(int[] arr, int i, int j) {
    
        int temp = arr[i];
    
        arr[i] = arr[j];
    
        arr[j] = temp;
    
      }
    

  }