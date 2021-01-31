//Check if Binary Tree is Symmetric (Mirror ) of Itself

//==== Shorter Version ===
public boolean isSymmetric(TreeNode root) {
    return root==null || isSymmetricHelp(root.left, root.right);
}

private boolean isSymmetricHelp(TreeNode left, TreeNode right){
    if(left==null || right==null)
        return left==right;
    if(left.val!=right.val)
        return false;
    return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
}


// === A more Comprehensive Version ====
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return solve(root.left,root.right);
    }
    private boolean solve(TreeNode left,TreeNode right){
        if(left==null &&  right==null) return true; //Both are null
        
        if(left!=null&&right!=null)
            if(left.val!=right.val) return false;
        
        if(left==null||right==null) return false; //One of them is null
        
        return solve(left.left,right.right) && solve(left.right,right.left);
    }
}