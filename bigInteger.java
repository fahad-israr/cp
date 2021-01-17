import java.io.*;
import java.math.*;

//---Link:  https://www.geeksforgeeks.org/biginteger-class-in-java/

class bigInteger{
  public static void main(String[]args)throws IOException{
    BigInteger b1=BigInteger.valueOf(10);
    BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    BigInteger b2=new BigInteger(obj.readLine());

    BigInteger product=b1.multiply(b2);
    BigInteger quotient=b2.divide(b1);
    int a=product.intValue();
    String res="Product: "+product.toString()+"\tQuotient: "+quotient.toString();

    System.out.println(res);
    System.out.println(a+" =a");
    System.out.println("IS Prime? "+checkPrime(b2.longValue()));
    System.out.println("NEXT Prime: "+nextPrime(b2.longValue()));
  }//main ends
  
  //Quick ways to check for Prime and find next Prime in Java
  /*ProbablePrime(int certainty): A method in BigInteger class to check if a given number is prime. For certainty = 1, it return true if BigInteger is prime and false if BigInteger is composite.
 */

 // isProbablePrime() uses Baillie–PSW primality test Algorithm
  static boolean checkPrime(long n) 
  { 
      // Converting long to BigInteger 
      BigInteger b = BigInteger.valueOf(n); 
      //Can also write: 

      return b.isProbablePrime(1); 
  } 
/* nextProbablePrime() : Another method present in BigInteger class. This functions returns the next Prime Number greater than current BigInteger.
Below is Java program to demonstrate above function. */
  static long nextPrime(long n) 
  { 
      BigInteger b = BigInteger.valueOf(n); 
      return Long.parseLong(b.nextProbablePrime().toString()); 
  } 

}//class ends