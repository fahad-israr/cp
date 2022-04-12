/*
Given a sorted array which is rotated ,search an Element in it .
Note : Elements can be equal.
Worst Case: When all are equal.
Example:
Array => 5 6 7  2 3 4
Search: 3
Answer = 4

Example 2:
I/p : [3,1,1]
o/p : 1

 */
class Solution {
    
  int min = -1;
  
  public int findMin(int[] nums) {
      int b = 0, e = nums.length - 1;
      min = nums[0];
      solve(nums, b, e);
      
      return min;
  }
  
  private void solve(int[] nums, int b, int e) {
     
      if(b > e){
          return;
      }
      
      int l = nums.length;
      
  
          
      int mid = b + ((e - b)/2);
      
      min = Math.min(Math.min(nums[b], nums[e]), Math.min(min,nums[mid]));
  
      //System.out.println("b: "+b+" e:"+e+" mid:"+mid);

      int prev = (mid - 1 + l) % l ;

      int next = (mid + 1) % l ;

      if(nums[mid] < nums[prev] && nums[mid] < nums[next]){
          min = nums[mid];
          return;
      }

      if(nums[mid] > nums[e]){
          solve(nums, mid+1, e);
      }
      else if(nums[mid] < nums[b]){
          solve(nums, b, mid - 1);
      } else {
          // nums[mid] == nums[b] && nums[mid] == nums[e]
          // Call both sides.
          solve(nums, mid+1, e);
          solve(nums, b, mid - 1);
          
      }
          
      
  }
}