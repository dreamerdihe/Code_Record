class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        
        int lastLast = 1
        int last = 1;
        int result = 0;
        int count = 1;
        while(count < n) {
            result = last + lastLast;
            lastLast = last;
            last = result;
            count ++;
        }
        
        return result;
    }
}