/*
69. Sqrt(x)
Easy

3652

3132

Add to List

Share
Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.

 

Example 1:

Input: x = 4
Output: 2
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
*/

class Solution {
    public int mySqrt(int x) {
        
        if(x <= 1){
            return x;
        }
        
        int b = 0, e =  x;
        
        int res = -1;
        
        while(b <= e){
            
            int mid = b + ((e - b)/2);
            
            double square  = 1.0 * mid * mid;
            
            if(square  == x)return mid;
            
            if(square > x) 
                e = mid - 1;
            else
            {
                b = mid + 1;
                res = mid;
            }
            
            
        }
        
        return res;
        
    }
}