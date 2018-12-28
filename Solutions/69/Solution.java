class Solution {
    public int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }
        
        if(x < 4) {
            return 1;
        }
        
        long lx = x;
        long next = 2;
        long last = next;
        while(next * next <= lx) {
            last = next;
            next *= next;
            if(next == lx) {
                return (int)last;
            }
        }
        
        long start = last;
        long end = next;
        
        while(start + 1 < end) {
            long mid = start + (end - start) / 2;
            if(mid * mid == lx) {
                return (int)mid;
            } else if( mid * mid > lx) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if(end * end < lx) {
            return (int)end;
        }
        
        if(start * start < lx) {
            return (int)start;
        }
        
        return -1;
    }
}