/*
Given a sorted array which is rotated ,search an Element in it .
Example:
Array => 5 6 7 1 2 3 4
Search: 3
Answer = 

Hint: The given array is simple made up  of two sorted array . See the {5 6 7} and {1 2 3 4} 
Their dividing point is 1 which is the minimum value in array.
We've already solved this problem in finding number of times an Array is Rotated.

 */
class searchInRotatedArray{
  public static void main(String... args){
    int a[] = {5,6,7,2,3,4} ;
    int key = 3;
    int min = minima(a);
    int res1 = find(a,0,min-1,key);
    int res2 = find(a,min,a.length-1,key);
    System.out.println(res1==-1?res2:res1);
  }

  //This function gives the index of minimum element
  static int minima(int[] a){
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
  } //---min(...) ends

  //---BINARY SEARCH

  static int find(int[]a,int b,int e,int key){
  
    while(b<=e){
      int mid = b+((e-b)/2);
      if(a[mid] == key) return mid;
      if(a[mid]>key) 
        e = mid - 1;
      else
        b = mid+1;    
    }
    return -1;
  }//---find(...) ends 

}