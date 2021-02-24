/* Collection framework*/
// ==> Asked about me
// ==> OOPS concepts 
// ==> Gave a program  and Asked Debugging: Requires good knowledge of Java to go through
// ==> Implement Stack Data Structure
// ==> Given a Table you had to find duplicate records and count  them. He shared sqlfiddle
/*
MY SOLUTION:
select country , store_id,sales, COUNT(*)
from 2019_Sales
Group By country , store_id, sales
Having COUNT(*)>1

Asked me if I had any questions.
 */

// 1 2 3 4 
import java.util.*;
class freshworks{
  public static void main(String... args){
    List<Integer> stack = new ArrayList<Integer>();


  }

  }
  
class stack{
  
  int [] st;
 // int size; //max size
  int top;

  stack(int size){
    createStack(size);
  }

  void createStack(int size){
    st = new int[size];
    top  = 0;
  }

  void push(int v){
    if(top == st.length)
      throw new RunTimeException("Stack Overflow");
    else
      st[top++]  = v;  
  }

  int pop(){
    if(top == 0)
      throw new RunTimeException("Stack Underflow");
    else
      return st[top--];
  }

  int top(){
    if(top == 0)
      throw new RunTimeException("Stack is Empty");
    else
      return st[top-1];      
  }

}