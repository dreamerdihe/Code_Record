class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }
        
        long ldividen = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        long result = helper(ldividen, ldivisor);
        result *= sign;
        if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)result;
    }
    
    private long helper(long ldividen, long ldivisor) {
        if(ldividen < ldivisor) {
            return 0;
        }
        
        long n = 1;
        long temp = ldivisor;
        while(temp + temp <= ldividen) {
            temp += temp;
            n += n;
        }
        
        return n + helper(ldividen - temp, ldivisor);
    }
}