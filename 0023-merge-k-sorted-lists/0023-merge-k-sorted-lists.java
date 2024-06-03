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
    public ListNode mergeKLists(ListNode[] lists) {
       if(lists.length==0) return null;
      
       return mergeK(lists,0,lists.length-1);
    }
    ListNode mergeK(ListNode[] lists,int s,int e){
        if(s==e)
        return lists[s];
        if(s+1==e){
            return merge(lists[s],lists[e]);
        }
        int mid=s+(e-s)/2;
        ListNode left=mergeK(lists,s,mid);
        ListNode right=mergeK(lists,mid+1,e);
        return merge(left,right);
    }
    ListNode merge(ListNode curr1,ListNode curr2){
       
    ListNode curr=new ListNode(0);
    ListNode dummy=curr;
   
        while(curr1!=null&&curr2!=null){
            if(curr1.val<curr2.val){
                dummy.next=curr1;
                dummy=dummy.next;
                curr1=curr1.next;
            }
            else{
                dummy.next=curr2;
                dummy=dummy.next;
                curr2=curr2.next;
            }

        }
        while(curr1!=null){
             dummy.next=curr1;
                dummy=dummy.next;
                curr1=curr1.next;
        }
        while(curr2!=null){
              dummy.next=curr2;
                dummy=dummy.next;
                curr2=curr2.next;
        }
        return curr.next;
    }
}