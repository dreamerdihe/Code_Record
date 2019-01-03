class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode current = head;
        ListNode prev = dummy;
        
        while(current != null) {
            
            if(prev == null || prev.val > current.val) {
                prev = dummy;    
            }
            ListNode next = current.next;
            
            while(prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }
            
            current.next = prev.next;
            prev.next = current;
            current = next;
        }
        
        return dummy.next;
    }
}