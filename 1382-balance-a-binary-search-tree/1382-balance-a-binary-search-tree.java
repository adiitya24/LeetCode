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
    List<TreeNode> list=new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        if(root==null) return  null;
        inorder(root);
        return constructTree(list,0,list.size()-1);
    }
    TreeNode constructTree(List<TreeNode> list,int low,int high){
      if(low>high) return null;
      int mid=(high-low)/2+low;
      TreeNode root=new TreeNode(list.get(mid).val);
      root.left=constructTree(list,low,mid-1);
      root.right=constructTree(list,mid+1,high);
      return root;
    }
    void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
}