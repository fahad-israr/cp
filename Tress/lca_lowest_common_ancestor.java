public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }
}

//-----A better solution that avoid traversal once we've found the val-----

class Solution {
    private TreeNode LCA;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Terminate early if LCA was already found in another branch
        if (LCA != null) return null;

        if (root == null) return root;

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both nodes lie in the left or right then their LCA is in the left or right
        // Otherwise root is their LCA
        if (left != null && right != null) {
            LCA = root;
            return LCA;
        };
        
        return (left != null) ? left : right;
    }
}