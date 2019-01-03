/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode left = reverse(slow);
        ListNode right = head;
        while(right != null && left != null) {
            if(right.val != left.val) {
                return false;
            }
            right = right.next;
            left = left.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode start) {
        ListNode prev = null;
        ListNode now = start;
        while(now != null) {
            ListNode temp = now.next;
            now.next = prev;
            prev = now;
            now = temp;
        }

        return prev;
    }
}