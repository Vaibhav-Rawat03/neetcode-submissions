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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head.next == null){
            return null;
        }

        ListNode counterNode = head;
        int size = 0;

        while(counterNode!=null){
            size++;

            counterNode = counterNode.next;
        }

        if(n == size){
            return head.next;
        }

        ListNode prevNode = head;
        ListNode currNode = head.next;
        ListNode nextNode = currNode.next;

        int count = 0;
        while(count < (size - n) - 1){
            prevNode = currNode;
            currNode = nextNode;
            nextNode = nextNode.next;

            count++;
        }

        prevNode.next = nextNode;

        return head;

    }
}