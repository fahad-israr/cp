/*
Given a sorted array which is rotated find the number of times it was rotated.
Example:
5 6 7 1 2 3 4
Answer = 3

Hint: See index of the minimum element 

 */
class numberOfRotation{
  public static void main(String... args){
    int a[] = {5,6,7,2,3,4} ;
    System.out.println(solve(a));
  }
  static int solve(int[] a){
    int n = a.length;
    int b = 0 , e = n-1 ;

    while(b<=e){
      int mid = b + ((e-b)/2); //mid = (b+e)/2
      System.out.println(b+" "+mid+" "+e);
      int nxt = (mid+1)%n; //normally we'd write mid+1 but we'll make it like Rotated Array
      int prev = (mid+n-1)%n; // normally ..... mid-1 ' ' '  ' ' '  
      
      if(a[mid]<a[prev] && a[mid]<a[nxt]) return mid; //Check if mid is minima

       if(a[mid]>a[prev] && a[mid]>a[nxt]) return nxt; //Check if mid is Maxima: return mid+1

      if(a[b]>a[mid]) 
        e = mid-1;
      else
        b = mid+1;
    }
    return 0 ;
  }

}