// O(n^2) use array but more tricky
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {      
        Arrays.sort(nums);
        int[] length = new int[nums.length];
        int[] prev = new int[nums.length];
        
        int index = -1; 
        int maxLength = 0;

        for(int i = 0; i < nums.length; i ++) {
            prev[i] = -1;
            length[i] = 1;
            for(int j = i - 1; j > -1; j --) {
                if(nums[i] % nums[j] == 0) {
                    if(length[i] < length[j] + 1) {
                        length[i] = length[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            
            if(maxLength < length[i]) {
                maxLength = length[i];
                index = i;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while(index != -1) {
            result.add(nums[index]);
            index = prev[index];
        }
            
        return result;
    }
}

// O(n ^ 2) use ArrayList very slow
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList();
        }
        
        List<List<Integer>> dp = new ArrayList<>(nums.length);
        
        Arrays.sort(nums);
        
        dp.add(new ArrayList());
        dp.get(0).add(nums[0]);
        List<Integer> result = dp.get(0);
        
        for(int i = 1; i < nums.length; i ++) {
            dp.add(new ArrayList<Integer>());
            int j = i - 1;
            
            while(j > -1) {
                if(nums[i] % dp.get(j).get(dp.get(j).size() - 1) == 0 && dp.get(i).size() < dp.get(j).size()) {
                    dp.get(i).clear();
                    dp.get(i).addAll(dp.get(j));
                }
                j --;
            }
            
            dp.get(i).add(nums[i]);
            if(result.size() < dp.get(i).size()) {
                result = dp.get(i);
            }
        }
        
        return result;
    }
}

