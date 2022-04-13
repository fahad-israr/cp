public class Solution{

     public static void main(String []args){
        int a[] = {10, 5, 30, 20, 40};
        
        System.out.println(solve(a, 10));
     }
     
    static int solve(int[] a, int target){
         int b = 0, e = a.length - 1;
         
         while(b <= e){
             int mid = b + (e - b)/2;
             
             if(a[mid] == target)return mid;
             
             
             int prev = (mid + a.length - 1) % a.length;
             
             int next = (mid + 1 )%a.length;
             
             // of the three elements mid, mid - 1 and mid + 1 , which ever lies in between the other two will be the actual middle element
             mid = a[mid] >= a[prev] && a[mid] <= a[next] ? mid :  a[prev] >= a[mid] && a[prev] <= a[next] ? prev : next;
             
             if(a[mid] == target)return mid;
             
            if(target > a[mid]) b = mid + 1;
            else e = mid - 1;
         }
         
         return -1;
     }
}