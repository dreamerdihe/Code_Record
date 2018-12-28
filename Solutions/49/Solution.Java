class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, Integer> mapping = new HashMap<>();
        for(String str : strs) {
            String key = getKey(str);
            if(mapping.containsKey(key)) {
                result.get(mapping.get(key)).add(str);
            } else {
                List<String> newAnagrams = new ArrayList<>();
                mapping.put(key, result.size());  
                newAnagrams.add(str);
                result.add(newAnagrams);
            }
        }
        
        return result;
    }
    
    private String getKey(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        String key = String.valueOf(array);
        return key;
    }
}