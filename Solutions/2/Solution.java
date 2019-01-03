class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode now = dummy;
        int last = 0;
        while(l1 != null || l2 != null) {
            int val = (l1 == null? 0 : l1.val) + (l2 == null? 0 : l2.val) + last;
            last = val / 10;
            now.next = new ListNode(val % 10);
            now = now.next;
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;
        }
        
        if(last > 0) {
            now.next = new ListNode(last);
        }
        
        return dummy.next;
    }
}