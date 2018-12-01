class Solution {
    public int findDuplicate(int[] nums) {
        
        int slow = 0;
        int fast = 0;
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(nums[slow] == nums[fast]) {
                break;
            }
        }
        
        if(slow != fast) {
            return nums[slow];
        }
        
        fast = 0;
        while(nums[fast] != nums[slow]) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return nums[fast];
    }
}