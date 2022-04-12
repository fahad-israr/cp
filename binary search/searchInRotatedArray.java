/*
Given a sorted array which is rotated ,search an Element in it .
Example:
Array => 5 6 7 1 2 3 4
Search: 3
Note: All elements are distinct


 */

class Solution {
  public int findMin(int[] nums) {
     
      int l = nums.length;
      int b = 0, e = nums.length - 1;
      
      while(b <= e){
          
          int mid = b + ((e - b)/2);
          
          int prev = (mid - 1 + l) % l ;

          int next = (mid + 1) % l ;
          
          if(nums[mid] < nums[prev] && nums[mid] < nums[next])return nums[mid];
          
          if(nums[mid] > nums[e]){
              b = mid + 1;
          }
          else{
              e = mid - 1;
          }
          
      }
      
      return nums[0] ; //Default case when all elements are equal
      
  }
  
}