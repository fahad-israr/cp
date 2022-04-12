
/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

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
