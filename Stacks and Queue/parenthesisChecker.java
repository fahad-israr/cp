// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;
/*
Given an expression string x. Examine whether the pairs and the orders of {}()[] are correct in exp.
For example, the function should return 'true' for exp = [()]{}{[()()]()} and false for exp = [(]).

Example 1:

Input:
{([])}

Output: 
true

Explanation: 
{ ( [ ] ) }. Same colored brackets can form 
balaced pairs, with 0 number of 
unbalanced bracket.
Example 2:

Input: 
()

Output: 
true

Explanation: 
(). Same bracket can form balanced pairs, 
and here only 1 type of bracket is 
present and in balanced way.
Example 3:

Input: 
([]

Output: 
false

Explanation: 
([]. Here square bracket is balanced but 
the small bracket is not balanced and 
Hence , the output will be unbalanced.

 */

 /*
 -------TESTCASE----------
 INPUT:
 -------
 3
{([])}
()
([]

OUTPUT:
--------
balanced
balanced
not balanced

  */
class parenthesisChecker
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Parenthesis().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}// } Driver Code Ends


class Parenthesis
{
    // Function to return if the paranthesis are balanced or not
    static boolean ispar(String x)
    {   
      Stack<Character> stack = new Stack<Character>();
      
      HashMap<Character,Character> map =  new HashMap<Character,Character>(); // Set contains Closing Characters: } ) ]

      map.put('}','{');
      map.put(')','(');
      map.put(']','[');

      for(char ch:x.toCharArray()){
          if(map.containsKey(ch)){
            if(stack.isEmpty()) return false; 
            char prev = stack.pop();
            if(prev != map.get(ch)) return false;
          }
          else{
            stack.push(ch);
          }          
        }
        return stack.isEmpty(); //If stack is empty return true
    }//---ispar(args...) ends
}
