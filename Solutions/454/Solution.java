class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int result = 0;
        for(int a : A) {
            for(int b : B) {
                int left = a + b;
                map.put(left, map.getOrDefault(left, 0) + 1);
                }
            }
        
        for(int c : C) {
            for(int d : D) {
                result += map.getOrDefault(-(c+d), 0);
            }
        }
        
        return result;
    }
}