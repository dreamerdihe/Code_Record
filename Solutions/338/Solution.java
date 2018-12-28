class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        int start = 1;
        int end = start << 1;
        while(start < num + 1) {
            int length = Math.min(num + 1, end);
            for(int i = start; i < length; i ++) {
                result[i] = 1 + result[i - start];
            }
            
            start <<= 1;
            end <<= 1;
        }
        
        return result;
    }
}