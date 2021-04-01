import java.util.Stack;

class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<Integer> s = new Stack<>();
        
        ListNode node = head;
        while (node != null) {
            s.push(node.val);
            node = node.next;
        }
        
        ListNode nodeTemp = null;
        int idx = 0;

        for(Integer e : s) {
            if (idx == 0) {
                nodeTemp = new ListNode(e);
                idx++;
            } else {
                nodeTemp = new ListNode(e, nodeTemp);
            }
        }
        
        return nodeTemp;
    }
}

/**
* 다른 풀이
*/

class Solution {
    ListNode head;

    public ListNode reverseList(ListNode head) {
        bs(head);
        return this.head;
    }

    public ListNode bs(ListNode node) {
        if (node == null) {
            head = null;
            return head;
        }
        
        ListNode newNode = new ListNode(node.val);

        if (node.next == null) {
            head = newNode;
            return newNode;
        }

        ListNode nodeTemp = bs(node.next);

        nodeTemp.next = newNode;
        return newNode;
    }
}