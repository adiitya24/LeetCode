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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
      if(root==null) return false;
        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot)||isSubtrees(root,subRoot);
    }
    boolean isSubtrees(TreeNode root,TreeNode subRoot){
        if(root==null&&subRoot==null) return true;
      if(root==null||subRoot==null) return false;
        if(root.val!=subRoot.val) {
            if(root.val!=subRoot.val) return false;
        }
        return isSubtrees(root.left,subRoot.left)&&isSubtrees(root.right,subRoot.right);
    }
}