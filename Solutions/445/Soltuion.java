class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> list1 = new Stack<>();
        Stack<Integer> list2 = new Stack<>();
        
        ListNode node1 = l1;
        while(node1 != null) {
            list1.push(node1.val);
            node1 = node1.next;
        }
        
        ListNode node2 = l2;
        while(node2 != null) {
            list2.push(node2.val);
            node2 = node2.next;
        }
        
        ListNode last = null;
        int carry = 0;
        while(!list1.isEmpty() || !list2.isEmpty() || carry != 0) {
            int num1 = !list1.isEmpty()? list1.pop() : 0;
            int num2 = !list2.isEmpty()? list2.pop() : 0;
            int position = num1 + num2 + carry;
            ListNode now = new ListNode(position % 10);
            carry = position / 10;
            now.next = last;
            last = now;
        }
        
        return last;
    }
}