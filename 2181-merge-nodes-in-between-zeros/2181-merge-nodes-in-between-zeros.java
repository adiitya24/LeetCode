/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        if(head==null) return null;
        ListNode ans=head.next;
        ListNode curr=ans;
        
        while(curr!=null){
            int sum=0;
            
            
            while(curr.val!=0){
                sum+=curr.val;
                curr=curr.next;
            }
            
           ans.val=sum;

           curr=curr.next;
           ans.next=curr;
           ans=curr;

        }
       
    

        return head.next;
    }
}