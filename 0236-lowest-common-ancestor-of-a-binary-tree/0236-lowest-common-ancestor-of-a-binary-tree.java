/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1=new ArrayList<>();
        List<TreeNode> list2=new ArrayList<>();
        root_to_node(root,p,list1);
        root_to_node(root,q,list2);
        int i=list1.size()-1;
        int j=list2.size()-1;
        TreeNode ans=null;
        while(i>=0&&j>=0){
            if(list1.get(i).val!=list2.get(j).val) break;

            ans=list1.get(i);
            i--;
            j--;
        }
        return ans;
    }
    boolean root_to_node(TreeNode root,TreeNode node,List<TreeNode> path){
        if(root==null) return false;
        if(root.val==node.val){
            path.add(root);
            return true;
        }
        boolean left=root_to_node(root.left,node,path);
        if(left){
            path.add(root);
            return true;
        }
        boolean right=root_to_node(root.right,node,path);
        if(right){
            path.add(root);
            return true;
        }
        return false;

    }
}