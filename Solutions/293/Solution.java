class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() < 2) {
            return result;
        }
        StringBuilder string = new StringBuilder(s);
        for(int i = 0; i < s.length() - 1; i++) {
            if(string.charAt(i) == '-' || string.charAt(i + 1) == '-') {
                continue;
            }

            string.replace(i, i+2, "--");
            result.add(string.toString());
            string.replace(i, i+2, "++");
        }
        
        return result;
    }
}