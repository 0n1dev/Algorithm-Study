class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ArrayList<Integer> arr = new ArrayList<>();

        while(l1 != null) {
            arr.add(l1.val);
            l1 = l1.next;
        }

        while(l2 != null) {
            arr.add(l2.val);
            l2 = l2.next;
        }
        
        if (arr.size() == 0) {
            return null;
        }

        Integer a[] = arr.toArray(new Integer[arr.size()]);
        
        Arrays.sort(a);
        
        ListNode tempNode = null;
        ListNode headNode = null;
        
        for (Integer ele : a) {
            if (headNode == null) {
                tempNode = new ListNode(ele);
                headNode = tempNode;
            } else {
                tempNode.next = new ListNode(ele);
                tempNode = tempNode.next;
            }
        }
        
        return headNode;
    }
}