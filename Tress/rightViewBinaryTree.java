  //=========WE WILL USE the LEVEL ORDER TRAVERSAL ================
  //========= REFER NEXT SOLUTION WHICH IS BETTER THAN THIS======
  //======= GOTO FILE: rightViewBinaryTree2.java
  
class Solution {
    ArrayList<ArrayList<Integer>> bfs;
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res = new ArrayList<Integer>();
        bfs = new ArrayList<ArrayList<Integer>>();
        
        levelOrderTraversal(root,0);
        
        for(ArrayList<Integer> temp:bfs){
            res.add(temp.get(temp.size()-1));
        }
       
        return res; 
    }
    private void levelOrderTraversal(TreeNode root,int h){
        if(root == null)return;
        
        if(bfs.size()<h+1)
            bfs.add(new ArrayList<Integer>());
        
        bfs.get(h).add(root.val);
        
        levelOrderTraversal(root.left,h+1);
        levelOrderTraversal(root.right,h+1);
    }
}