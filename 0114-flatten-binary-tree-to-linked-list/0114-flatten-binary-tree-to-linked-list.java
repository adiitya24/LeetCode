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
    public void flatten(TreeNode root) {
        Deque<TreeNode> q=new ArrayDeque<>();
        preorder(root,q);
        if(root==null||root.left==null&&root.right==null) return;
    root.left=null;
    root.right=null;
    TreeNode curr=root;
    while(!q.isEmpty()){
        curr.right=q.pollFirst();
        curr.left=null;
          System.out.println(curr.right.val);
        curr=curr.right;
     
    }
    root=root.right;       

    }
    
    void preorder(TreeNode root,Queue<TreeNode> q){
        if(root==null) return ;
        q.add(root);
        preorder(root.left,q);
        preorder(root.right,q);


    }
}