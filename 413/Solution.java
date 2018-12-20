class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3) {
            return 0;
        }
        
        int result = 0;
        int i = 1;
        while(i < A.length) {
            int dif = A[i] - A[i - 1];
            int j = i + 1;
            int count = 2;
            while(j < A.length && A[j] - A[j - 1] == dif) {
                j ++;
                count ++;
            }
            i = j;
            result += (count - 1) * (count - 2) / 2;
        }
        
        return result;
    }
}