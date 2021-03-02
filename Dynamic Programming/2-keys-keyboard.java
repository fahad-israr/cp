
//LEETCODE
//2 Keys Keyboard : https://leetcode.com/problems/2-keys-keyboard/
class Solution {
    public int minSteps(int n) {
        int[]dp = new int[n+1];
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                if(i%j == 0) dp[i] = (i/j)+dp[j];
            }
        }
        return dp[n];
    }
}

