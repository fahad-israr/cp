/*

Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 */

 class Solution {
    public Node connect(Node root) {
        solve(root);
        return root;
    }
    
    private void solve(Node root){
        if(root == null || (root.left == null && root.right == null))// Check if its NULL OR Leaf Node 
            return;
        
        // Figure out the next rightwards node 
        Node nxt = root.next;
        
            while(nxt !=null){
                if(nxt.left != null || nxt.right != null)
                    break;
                nxt = nxt.next;
            }
            
        Node nextRight = null;
        if(nxt != null)         // THE nxt will be null in case of root of the Tree
        nextRight = nxt.left == null ? nxt.right : nxt.left ;
        
        if(root.right == null )
            root.left.next = nextRight  ;
        else
        if(root.left == null)
            root.right.next = nextRight ;
        else
        {
            root.left.next = root.right;
            root.right.next = nextRight ;
        }
        
        solve(root.right);
        solve(root.left);
        
            
    }
}