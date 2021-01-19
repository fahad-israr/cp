/*
Given a sorted array which is rotated ,search an Element in it .
Example:
Array => 5 6 7  2 3 4
Search: 3
Answer = 4


 */
class searchInRotatedArray2{
  public static void main(String... args){
    int a[] = {5,6,7,2,3,4} ;
    int key = 3;

    System.out.println(find(a,key));
  }
  
  static int find(int[]a,int key){
    int b = 0, e = a.length-1;
    while(b<=e){
      int mid = b + (e-b)/2 ;
      if(a[mid] == key) return mid;
      // if beg -> mid is sorted and key lies in this range
      if(a[mid]>=a[b] && a[b]<=key && key<a[mid])
        e = mid - 1;
      else
      // if mid -> end is sorted and key lies in this range
      if(a[mid]<=a[e] && key>a[mid] && key<a[e])
        b = mid + 1;
      else
      // if beg--> mid is not sorted
      if(a[b]>a[mid])
        e = mid - 1;
      
      else b = mid +1;

    }
    return -1;
  }

}