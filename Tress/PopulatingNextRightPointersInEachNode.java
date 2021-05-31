/*
@ LEETCODE
Populating Next Right Pointers in Each Node

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
 */

 class Solution {
    public Node connect(Node root) {
        
        if(root==null)return null;
        
        if(root.left!=null)
        root.left.next=root.right;
        
        if(root.right!=null)
        root.right.next=root.next==null?null:root.next.left;
        
        connect(root.left);
        connect(root.right);
        
        return root;
        
        
    }