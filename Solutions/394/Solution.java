class Solution {
    public String decodeString(String s) {
        
        return decode(s, 0, s.length() - 1); 
    }
    
    private String decode(String s, int left, int right) {
        String result = "";
        
        int start = left;
        while(start <= right) {
            while(start <= right && (s.charAt(start) > '9' || s.charAt(start) < '0')) {
                start ++;
            }
            
            int num = start;
                
            if(start > right) {
                result += s.substring(left, right + 1);
                break;
            }
            
            String rep_ = "";
            while(s.charAt(start) != '[') {
                rep_ += s.charAt(start);
                start ++;
            }
            
            int rep = Integer.parseInt(rep_);
            
            int end = start;
            int leftCount = 0;
            int rightCount = 0;
            while(end <= right) {
                if(s.charAt(end) == '[') {
                    leftCount ++;
                }

                if(s.charAt(end) == ']') {
                    rightCount ++;
                }

                if(leftCount == rightCount) {
                    break;
                }
                end ++;
            }
            String repPart = decode(s, start + 1, end - 1);
            String repeat = "";
            for(int i = 0; i < rep; i ++) {
                repeat += repPart;
            }
            
            result += (s.substring(left, num) + repeat);
            left = end + 1;
            start = end + 1;
        }
        
        return result;
    }
}