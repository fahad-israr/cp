/*
744. Find Smallest Letter Greater Than Target
Easy

1527

1390

Add to List

Share
Given a characters array letters that is sorted in non-decreasing order and a character target, return the smallest character in the array that is larger than target.

Note that the letters wrap around.

For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
 

Example 1:

Input: letters = ["c","f","j"], target = "a"
Output: "c"
Example 2:

Input: letters = ["c","f","j"], target = "c"
Output: "f"
Example 3:

Input: letters = ["c","f","j"], target = "d"
Output: "f"
*/

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        int b = 0, e = letters.length - 1;
        char res = letters[0];
        
        while(b <= e){
            
            int mid = b + ((e - b)/2);
            
            if(target >= letters[mid]){
                b = mid + 1;
            } else {
                res = letters[mid];
                e = mid - 1;
            }
            
        }
        
        return res;
        
    }
}