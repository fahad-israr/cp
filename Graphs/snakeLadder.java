import java.util.*;
import java.lang.*;
import java.io.*;
/*
Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains two lines. The first line of input contains an integer N denoting the no of ladders and snakes present. Then in the next line are 2*N space separated values a,b which denotes a ladder or a snake at position 'a' which takes to a position 'b'.

Output:
For each test case in a new line print the required answer denoting the min no of dice throws.

Constraints:
1 <= T <= 100
1 <= N <= 10
1 <= a <= 30
1 <= b <= 30

Example:
Input:
2
6
11 26 3 22 5 8 20 29 27 1 21 9
1
2 30

Output:
3
1

Explanation:
Testcase 1:
For 1st throw get a 2, which contains ladder to reach 22
For 2nd throw get a 6, which will lead to 28
Finally get a 2, to reach at the end 30. Thus 3 dice throws required to reach 30.

 */

class snakeLadder
 {  
    static BufferedReader obj;
    
    final static int INF = Integer.MAX_VALUE;

	public static void main (String[] args)throws IOException
	 {
	   obj = new BufferedReader(new InputStreamReader(System.in));
	   int t = ni(); 
       while(t-->0){
        int n = ni();
        int a[] = Arrays.stream(obj.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int p=0;
        Vertex [] v = new Vertex[31];
        for(int i=0;i<31;i++)
        v[i] = new Vertex(i,i+1);

        for(int i=0;i<n;i++){
          int src = a[p++];
          int dst = a[p++];
          v[src].next = dst;
        }
        boolean visited[]=new boolean[31];
      
        System.out.println(solve(v,1,visited));
       
       }//---wihle(tescases)ends    
	 }
   static int solve(Vertex[] v ,int curr ,boolean[]visited){
     System.out.println(curr);
     if(curr >= 30)return 0;
     if(visited[curr])return INF/100;
   
     
     visited[curr] = true;
     // if snake
     if(v[curr].next<curr && visited[v[curr].next]) return INF/100;
    //if ladder
    //if(v[curr].next!=curr+1 && visited[v[curr].next]) return INF;
    if(v[curr].next!=curr+1) return solve(v,v[curr].next,visited);

    
      int m1 = solve(v,curr+1,visited);
      int m2 = solve(v,curr+2,visited);
      int m3 = solve(v,curr+3,visited);
      int m4 = solve(v,curr+4,visited);
      int m5 = solve(v,curr+5,visited);
      int m6 = solve(v,curr+6,visited);

      int Max1 = Math.max(m1,m2);
      int Max2 = Math.max(m3,m4);
      int Max3 = Math.max(m5,m6);
      return 1+Math.max(Math.max(Max1,Max2),Max3);
   }//---solve() ends---

	 static int ni()throws IOException{
	     return Integer.parseInt(obj.readLine());
	 }
   static class Vertex{
     int val,next;
     Vertex(int val,int next){
       this.val = val;
       this.next = next;
     }
   }//---Vertex call ends here
}