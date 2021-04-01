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