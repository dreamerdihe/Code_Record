class Solution {
    public String reverseString(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        // O(n)
        char[] string = s.toCharArray(); 
        int start = 0;
        int end = s.length() - 1;

        while(start < end) {
            swap(string, start, end);
            start++;
            end--;
        }

        return new String(string);
    }

    private static void swap(char[] string, int start, int end) {
        char temp = string[start];
        string[start] = string[end];
        string[end] = temp;
    }

    public static void main(String[] args) {
        String input = "look";
        Solution solution = new Solution();
        String result = solution.reverseString(input);
        System.out.println(result);
    }
}