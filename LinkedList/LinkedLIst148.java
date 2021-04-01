// 시간초과
class Solution {
    public ListNode sortList(ListNode head) {
        ListNode idxNode = head;
        
        if (head == null) {
            return null;
        }

        while(idxNode != null) {
            head = bs(head);
            idxNode = idxNode.next;
        }

        return head;
    }

    public ListNode bs(ListNode node) {
        if (node.next == null) {
            return node;
        }

        ListNode nextNode = bs(node.next);

        if (node.val > nextNode.val) {
            ListNode tempNode = new ListNode(node.val, nextNode.next);
            nextNode.next = tempNode;
            return nextNode;
        }
        
        node.next = nextNode;
        return node;
    }
}

// Merge sort
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middleNode = findMiddleNode(head);
        ListNode rightNode = middleNode.next;
        middleNode.next = null;

        return merge(sortList(head), sortList(rightNode));
    }

    private ListNode findMiddleNode(ListNode node) {
        ListNode slow = node;
        ListNode fast = node.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode merge(ListNode leftNode, ListNode rightNode) {
        if (leftNode == null) {
            return rightNode;
        }
        
        if (rightNode == null) {
            return leftNode;
        }
        
        if (leftNode.val < rightNode.val) {
            leftNode.next = merge(leftNode.next, rightNode);
            return leftNode;
        } else {
            rightNode.next = merge(leftNode, rightNode.next);
            return rightNode;
        }
    }
}