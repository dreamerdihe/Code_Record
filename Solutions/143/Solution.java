class Solution {
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        // find middle point
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode right = slow.next;
        slow.next = null;
        
        // reverse
        ListNode prev = null;
        while(right != null) {
            ListNode temp = right.next;
            right.next = prev;
            prev = right;
            right = temp;
        }
        
        // generate new linkedlist
        ListNode dummy = new ListNode(-1);
        ListNode left = head;
        right = prev;
        ListNode current = dummy;
        while(left != null) {
            current.next = left;
            left = left.next;
            current.next.next = right;
            if(right != null){
                right = right.next;
            }
            current = current.next.next;
        }
    }
}