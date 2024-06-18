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
    class Pair{
        int pos;
        TreeNode node;
        Pair(int pos,TreeNode node){
            this.pos=pos;
            this.node=node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        int ans=0;
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            int size=q.size();
            int min=q.peek().pos;
            int first=0,last=0;
            for(int i=0;i<size;i++){
                Pair p=q.poll();
                int curr=p.pos-min;
                TreeNode node=p.node;
                if(i==0) first=curr;
                if(i==size-1) last=curr;
                if(node.left!=null) q.add(new Pair((2*curr)+1,node.left));
                if(node.right!=null) q.add(new Pair((2*curr)+2,node.right));
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}