/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

IMP!! === Same Approach as Binary Tree from Inorder and PostOrder ===
*/

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        Map<Integer,Integer> reverseMap = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++)
            reverseMap.put(inorder[i],i);
        
        return solve(preorder,inorder,0,inorder.length-1,0,reverseMap);
        
    }
    
    private TreeNode solve(int[] preorder, int[] inorder, int instart,int inend,int prestart, Map<Integer,Integer> reverseMap){
       
        if(instart>inend)return null;
        
        int rootVal = -1;
        for(; prestart< preorder.length;prestart++)
        {   
            rootVal = preorder[prestart];
            int pos = reverseMap.get(rootVal);
            if(pos>=instart && pos <= inend)
                break;

        }
            
        TreeNode root = new TreeNode(rootVal);
        root.left = solve(preorder,inorder, instart,reverseMap.get(rootVal)-1,prestart+1,reverseMap );
        root.right = solve(preorder,inorder, reverseMap.get(rootVal)+1,inend,prestart+1,reverseMap );
        
        return root;
        
    }
    
}