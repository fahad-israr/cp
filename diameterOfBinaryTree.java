/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        ans = -1;
        solve(root);
        return ans;
    }
    private int solve(TreeNode root){
        if(root == null) return 0;
        int lh = solve(root.left);
        int rh = solve(root.right);
        ans = Math.max(ans,lh+rh);
        return 1+Math.max(lh,rh);
    }
}