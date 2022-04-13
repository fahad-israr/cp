/*
Search Insert Position
Easy

7401

399

Add to List

Share
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4

=========== NOTE:  In This Problem you have to find the element poistion it were to be placed. You can use similar approach to find the floor.
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int b  = 0, e = nums.length - 1;
        
        
        int res = 0;
        
        while(b <= e){
            int mid = b + (e - b)/2;
            
            if(nums[mid] == target)return mid;
            
            if(nums[mid] < target)res = mid + 1;
            
            if(target < nums[mid])
                e = mid - 1;
            else
                b = mid + 1;     
            
        }
        
        return res;
    }
}