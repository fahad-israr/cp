class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
       
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            while(curr!=null){
                res.add(curr.val);
                stack.push(curr.right);
                curr = curr.left;
            }
        }
        return res;
    }//fx(args.. ) ends
}