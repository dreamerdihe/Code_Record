public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length1 = getLength(headA);
        int length2 = getLength(headB);
        int diff = 0;
            
        ListNode longer = null;
        ListNode shorter = null;
        if(length1 > length2) {
            longer = headA;
            shorter = headB; 
            diff = length1 - length2;
        } else {
            longer = headB;
            shorter = headA;
            diff = length2 - length1;
        }
        
        for(int i = 0; i < diff; i ++) {
            longer = longer.next;
        }
        
        while(longer != null && shorter != null) {
            if(longer == shorter) {
                return longer;
            }
            
            longer = longer.next;
            shorter = shorter.next;
        }
        
        return null;
    }
    
    private int getLength(ListNode node) {
        int length = 0;
        while(node != null) {
            node = node.next;
            length ++;
        }
        
        return length;
    }
}