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

    public ListNode reverse(ListNode head){

        if(head==null || head.next==null){
            return head;
        }

        ListNode prevNode = head;
        ListNode currNode = head.next;
        ListNode nextNode = currNode.next;

        while(nextNode!=null){
            currNode.next = prevNode;

            prevNode = currNode;
            currNode = nextNode;
            nextNode = nextNode.next;
        }

        currNode.next = prevNode;

        head.next = null;
        head = currNode;

        return head;
    }

    public void reorderList(ListNode head) {
        
        if(head.next == null){
            return;
        }

        int size = 0;
        ListNode counterNode = head;

        while(counterNode!=null){
            size++;
            counterNode = counterNode.next;
        }

        int half = size/2;

        ListNode midNode = head;

        while(half>1){
            half--;
            
            midNode = midNode.next;
        }

        ListNode secHead = reverse(midNode.next);
        midNode.next = null;

        ListNode prev1 = head;
        ListNode curr1 = head.next;

        ListNode prev2 = secHead;
        ListNode curr2 = secHead.next;

        while(curr1!=null && curr2!=null){
            prev1.next = prev2;

            prev2.next = curr1;

            prev1 = curr1;
            curr1 = curr1.next;

            prev2 = curr2;
            curr2 = curr2.next;
        }

        prev1.next = prev2;
    }
}