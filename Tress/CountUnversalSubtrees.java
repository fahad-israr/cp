/*
Probelm:  Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

GFG LInk : https://www.geeksforgeeks.org/find-count-of-singly-subtrees/

My Solution :
*/
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    int res;
    public int countUnivalSubtrees(TreeNode root) {
        res = 0;
        solve(root);
        return res ;
    }
    private boolean solve(TreeNode root){

        if(root == null)return true;

        if((root.left!=null && root.left.val != root.val)||(root.right!=null && root.val != root.right.val) )
        {
            solve(root.left);
            solve(root.right);
            return false;
        }
        else{
        boolean isUni = solve(root.left) && solve(root.right) ;
        if(isUni)res++;
        return isUni;
    }
    }
}