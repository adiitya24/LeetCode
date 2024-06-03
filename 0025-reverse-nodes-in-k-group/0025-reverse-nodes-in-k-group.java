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
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode prevTail=null,currHead=head,currTail=head;
       ListNode nextHead=null;
       while(currHead!=null){
        int count=1;
        while(currTail.next!=null&&count<k){
            currTail=currTail.next;
            count++;
        }
        if(count!=k) break;
        nextHead=currTail.next;
        currTail.next=null;
        if(prevTail!=null){
            prevTail.next=null;
        }

        currTail=reverse(currHead);
        if(prevTail!=null){
            prevTail.next=currTail;
        }
        else{
            head=currTail;
        }
        currHead.next=nextHead;
        prevTail=currHead;
        currHead=nextHead;
        currTail=nextHead;
        

       }
       return head;
       
    }
    ListNode reverse(ListNode head){
        ListNode curr=head,prev=null;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}