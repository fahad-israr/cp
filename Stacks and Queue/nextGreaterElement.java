/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
/*
======= FOR SOLUTION REFER ADITYA VERMA VIDEO ======
 */
/*
Given an array arr[ ] of size N having distinct elements, the task is to find the next greater element for each element of the array in order of their appearance in the array.
Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater of the last element is always -1.

Example 1:

Input: 
N = 4, arr[] = [1 3 2 4]
Output:
3 4 4 -1
Explanation:
In the array, the next larger element 
to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? 
since it doesn't exist, it is -1.
Example 2:

Input: 
N = 5, arr[] [6 8 0 1 3]
Output:
8 -1 1 3 -1
Explanation:
In the array, the next larger element to 
6 is 8, for 8 there is no larger elements 
hence it is -1, for 0 it is 1 , for 1 it 
is 3 and then for 3 there is no larger 
element on right and hence -1.
 */

 /*
 TESTCASE:
 --------
INPUT:
------
1
4
1 3 2 4

OUTPUT
------
3 4 4 -1

  */
class nextGreaterElement {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new solve().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}



// } Driver Code Ends


class solve{
    public static long[] nextLargerElement(long[] arr, int n) { 
      long[]res = new long[n];
      Stack<Long> stack = new Stack<Long>();

      for(int i = n-1; i>=0; i--){ // Moving from Right to Left
        if(stack.isEmpty()){ // If stack is Empty then we have no element Greater
          res[i] = -1;
          stack.push(arr[i]);
        }
        else
        if(stack.peek()>arr[i]){  // Yayyy we found a Greater Element 
          res[i] = stack.peek();
          stack.push(arr[i]);
        }
        else{                     // Stack is not Empty and Element not greater 

          while((!stack.isEmpty()) && stack.peek()<=arr[i])
             stack.pop();      //Keep Popping until you find a greater       

          if(stack.isEmpty()){
            res[i] = -1;
            stack.push(arr[i]);
          }
          else{
            res[i] = stack.peek();
            stack.push(arr[i]);
          }
        }//else ends
      }

      return res;
    }//--fx(args...)  ends ---
}