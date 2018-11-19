class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strArray = str.split(" ");
        if(strArray.length != pattern.length()) {
            return false;
        }
        HashMap<Character, Integer> patternMapping = new HashMap<>();
        HashMap<String, Integer> strMapping = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            if(!Objects.equals(patternMapping.put(pattern.charAt(i), i), strMapping.put(strArray[i], i))) {
                return false;
            }
        }
        
        return true;
    }
}