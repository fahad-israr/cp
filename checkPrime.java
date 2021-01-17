import java.io.*;
class checkPrime{
public static void main(String[]args)throws IOException{
BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
int n=Integer.parseInt(obj.readLine());
System.out.println(new checkPrime().checkPrime(n));

}
 boolean checkPrime(int n){
    n=(int)Math.sqrt(n);
    for(int i=2;i<n;i++)
    if(n%i==0)return false;

    return true;
}//-------checkPrime ends
}//---------class ends