/*
Given a string and a regular expression pattern, give the number of times the pattern occurs in the string. RegEx example means as follows:
. – 2 occurrences of the previous character
+ – 4 occurrences of the previous character
* – more than 5 occurrences of the previous character

Sample Input:
5
aaaaaannndnnnnnnfffhfhhgjjjwkkkllclc
a.
n+
a*
an.
a.d.

Sample Output:
5
3
2
1
0
*/
import java.io.*;

class pattern{
  public static void main(String... args)throws IOException{
    BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parse(obj.readLine());
    String s = obj.readLine();
    while(t-->0){
      String p = obj.readLine();
      String fp = "";
      for(int i=0;i<p.length();i++)
    }
  }//--main(args..)
}