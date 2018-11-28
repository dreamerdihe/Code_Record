class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) {
            return true;
        }
        
        int lastIndex = nums.length - 1;
        for(int i = nums.length - 2; i > -1 ; i--) {
            if(nums[i] >= lastIndex - i) {
                if(i == 0) {
                    return true;
                }
            lastIndex = i;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = {2,3,1,1,4};
        Solution solution = new Solution();
        boolean result = solution.canJump(input);
        System.out.println(result);
    }
}
