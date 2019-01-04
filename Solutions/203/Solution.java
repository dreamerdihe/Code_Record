class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode now = dummy;
        while(now.next != null) {
            if(now.next.val == val) {
                now.next = now.next.next;
                continue;
            }
            
            now = now.next;
        }
        
        return dummy.next;
        
    }
}