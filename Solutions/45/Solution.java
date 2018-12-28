class Solution45 {
    public int jump(int[] nums) {        
        int count = 0;
        int now = 0;
            
        while(now < nums.length - 1) {
            int next = Integer.MIN_VALUE;
            int pos = -1;
            for(int i = 1; i <= nums[now]; i++) {
                if(now + i == nums.length - 1) {
                    count ++;
                    return count;
                }
                
                if(nums[now + i] + i > next) {
                    next = nums[now + i] + i;
                    pos = now + i;
                }
            }

            now = pos;
            count ++;
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[] input = {5,9,3,2,1,0,2,3,3,1,0,0};
        Solution45 solution = new Solution45();
        int result = solution.jump(input);
        System.out.println(result);
    }
}


