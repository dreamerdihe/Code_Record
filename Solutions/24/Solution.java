class Solution {
    public ListNode swapPairs(ListNode head) {
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode current = head;
        while(current != null && current.next != null) {
            ListNode next = current.next.next;
            prev.next = current.next;
            prev.next.next = current;
            current.next = null;
            current = next;
            prev = prev.next.next;
        }
        
        if(current != null) {
            prev.next = current;
        }
        
        return dummy.next;
    }
}