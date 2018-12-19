class NumArray {
    private int[] sums;
    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        for(int i = 1; i < sums.length; i ++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        return sums[j+1] - sums[i];
    }
}