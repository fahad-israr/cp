/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:

[4,5,6,7,0,1,4] if it was rotated 4 times.
[0,1,4,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.

You must decrease the overall operation steps as much as possible.
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