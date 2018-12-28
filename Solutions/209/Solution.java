// O(n)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int l = Integer.MAX_VALUE;
        while(start < nums.length) {
            if(sum >= s) {
                l = Math.min(l, end - start);
                sum -= nums[start];
                start ++;
                continue;
            }
            
            if(sum < s) {
                if(end == nums.length) {
                    break;
                }
                sum += nums[end];
                end ++;
            }
        }
        
        if(l == Integer.MAX_VALUE) {
            return 0;
        }
        
        return l;
    }
}

// O(nlogn) this is for the follow up
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int[] cul = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i ++) {
            cul[i] = cul[i-1] + nums[i-1];
        }
        int l = Integer.MAX_VALUE;
        
        for(int start = 0; start < cul.length - 1; start ++) {
            int temp = bs(start, cul, s);
            l = Math.min(l, temp);
        }
        
        if(l == Integer.MAX_VALUE) {
            return 0;
        }
        
        return l;
    }
    
    private int bs(int start, int[] nums, int s) {
        int fixed = nums[start];
        int left = start + 1;
        int right = nums.length - 1;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] - fixed >= s) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if(nums[left] - fixed >= s) {
            return left - start;
        }
        
        if(nums[right] - fixed >= s ) {
            return right - start;
        }
        
        return Integer.MAX_VALUE;
    }
}