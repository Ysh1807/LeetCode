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
    public void reorderList(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while(f!=null && f.next!=null){
            s = s.next;
            f = f.next.next;
        }

        ListNode temp = s.next;
        s.next = null;

        ListNode prev = null;
        ListNode curr = temp;

        while(curr!=null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
            
        }

        ListNode temp_head = head;
        while(temp_head!=null && prev!=null){
            ListNode temp1 = temp_head.next;
            ListNode temp2 = prev.next;
            
            temp_head.next = prev;
            prev.next = temp1;

            temp_head = prev.next;
            prev = temp2;
        }
        
    }
}