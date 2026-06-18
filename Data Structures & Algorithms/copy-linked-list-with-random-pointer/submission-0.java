/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        if(head == null){
            return null;
        }
       
        Node curr = head;

        HashMap<Node , Node> hm = new HashMap<>();

        //Pass 1 Creating new node
        while(curr!=null){

            Node newNode = new Node(curr.val);

            hm.put(curr , newNode);

            curr = curr.next;

        }
        
        //Pass 2 Joining them

        curr = head;

        Node newCurr = hm.get(curr);

        while(curr!=null){
            newCurr.next = hm.get(curr.next);

            newCurr.random = hm.get(curr.random);

            curr = curr.next;

            newCurr = newCurr.next;

        }

        return hm.get(head);
    }
}