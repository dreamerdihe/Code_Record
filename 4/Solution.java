// trivial version O(n)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> nums = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        int length = nums1.length + nums2.length;
        
        for(int i = 0; i < length; i ++) {
            int num1 =  index1 < nums1.length? nums1[index1] : Integer.MAX_VALUE;
            int num2 =  index2 < nums2.length? nums2[index2] : Integer.MAX_VALUE;
            
            if(num1 <= num2) {
                nums.add(num1);
                index1 ++;
            } else {
                nums.add(num2);
                index2 ++;
            }
        }
        
        if(nums.size() % 2 == 0) {
            return ((double)nums.get(nums.size() / 2) + (double)nums.get(nums.size() / 2 - 1)) / 2;
        }
        
        return (double)nums.get(nums.size() / 2);
    }
}