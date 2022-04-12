
/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Sove the problem in linear time and in O(1) space?
*/

// ============= SOLN 1 : AN INTERESTING APPROACH but nlogn ==========
// Logic : When an element appears more than n/2 times in the array, the middle one must be the "majority" number when array is sorted.
public int majorityElement(int[] nums) {
     Arrays.sort(nums);
     return nums[nums.length/2]; // 
}

// ============= SOLN 2 : O(n) time  and  O(1) space : Boyer Moore's Majority Voting Algorithm==========
  public int majorityElement(int[] num) {
		int count = 0; int major = num[0];
		for(int i:num) {
			if(count==0){ major=i; count++;	}
			else if(i==major) count++;
			else count--;
		}
		return major;
	}


// =========== SOLN 3 : O(n) time and space ===============

// Using a  HashMap/Array to Store count
