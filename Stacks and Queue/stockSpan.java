// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


/*
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stock’s price for all n days. 
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.

Example 1:

Input: 
N = 7, price[] = [100 80 60 70 60 75 85]
Output:
1 1 1 2 1 4 6
Explanation:
Traversing the given input span for 100 
will be 1, 80 is smaller than 100 so the 
span is 1, 60 is smaller than 80 so the 
span is 1, 70 is greater than 60 so the 
span is 2 and so on. Hence the output will 
be 1 1 1 2 1 4 6.
Example 2:

Input: 
N = 6, price[] = [10 4 5 90 120 80]
Output:
1 1 2 4 5 1
Explanation:
Traversing the given input span for 10 
will be 1, 4 is smaller than 10 so the 
span will be 1, 5 is greater than 4 so 
the span will be 2 and so on. Hence, the 
output will be 1 1 2 4 5 1.

===========================
TESTCASE
======================
INPUT
-------
1
7
100 80 60 70 60 75 85

OUTPUT
--------
1 1 1 2 1 4 6
=============================
## Good Test Case
=============================
Input:
42
68 735 101 770 525 279 559 563 465 106 146 82 28 362 492 596 743 28 637 392 205 703 154 293 383 622 317 519 696 648 127 372 339 270 713 68 700 236 295 704 612 123

Its Correct output is:
1 2 1 4 1 1 3 4 1 1 2 1 1 5 7 12 13 1 2 1 1 5 1 2 3 4 1 2 7 1 1 2 1 1 18 1 2 1 2 5 1 1
=================================================================================
 */
class stockSpan
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new solve().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}// } Driver Code Ends

//=============
//### HINT : FIND Nearest greater number on the left with a bit modification (think a good case)
//============
class solve{
    
    // Function to calculate span
    // price[]: input array
    public static int[] calculateSpan(int price[], int n)
    {
        int[]res = new int[n];
        Arrays.fill(res,1);
        Stack<Integer> stack = new Stack<Integer>();
        // Instead of pushing numbers lets put their indices in the stack ; easy for solving

        for(int i=0;i<n;i++){
          if(stack.empty()){
            //If stack is empty then res =  i+1 
            res[i] = i+1; 
            stack.push(i);  
          }
          //Stack not empty and top element price less than this 
          else if(price[stack.peek()]>price[i]){
            res[i] = i - stack.peek();
            stack.push(i);
          }

          else{
            while((!stack.empty()) && price[stack.peek()]<= price[i])
              stack.pop();
            if(!stack.empty())
              res[i] = i - stack.peek();
            else
              res[i] = i+1; //You didn't find anything bigger on left
            stack.push(i);
          }

        }//---for(...) ends
      return res;
    }//---fx(args...) ends ---
    
}