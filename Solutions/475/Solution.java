// two pointer
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int i = 0, j = 0, res = 0;
        while (i < houses.length) {
            while (j < heaters.length - 1
                && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {
                j++;
            }
            res = Math.max(res, Math.abs(heaters[j] - houses[i]));
            i++;
        }
        
        return res;
    }
}

// bs
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        
        int r = 0;
        for(int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if(index >= 0) {
                continue;
            }
            
            index = -(index + 1);
            int left = index == 0? Integer.MAX_VALUE : house - heaters[index - 1];
            int right = index == heaters.length? Integer.MAX_VALUE : heaters[index] - house;
            
            r = Math.max(r, Math.min(left, right));
        }
        
        return r;
    }
}

// Not very smart
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int end = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]); 
        int start = 0;
        while(start  + 1 < end) {
            int mid = start + (end - start) / 2;
            if(canCover(houses, heaters, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if(canCover(houses, heaters, start)) {
            return start;
        } else {
            return end;
        }
        
    }
    
    private boolean canCover(int[] houses, int[] heaters, int r) {
        int hs = 0;
        int ht = 0;
        while(hs < houses.length && ht < heaters.length) {
            if(houses[hs] <= heaters[ht] + r && houses[hs] >= heaters[ht] - r) {
                hs ++;
                continue;
            }
            
            ht ++;
        }
        
        return hs == houses.length;
    }
}