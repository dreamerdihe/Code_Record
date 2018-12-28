import java.util.*;

class Solution {
    public String reverseVowels(String s) {

        char[] string = s.toCharArray();
        int start = 0;
        int end = string.length - 1;

        while(start < end) {
            while(start < end && !isVowel(string[start])) {
                start ++;
            }

            while(start < end && !isVowel(string[end])) {
                end --;
            }

            char temp = string[start];
            string[start] = string[end];
            string[end] = temp;
            start ++;
            end --;
        }

        return new String(string);
    }

    private static boolean isVowel(char chr) {
        return chr == 'a' || chr == 'e' || chr == 'i' || 
               chr == 'o' || chr == 'u' || chr == 'A' || chr == 'E' || chr == 'I' || 
               chr == 'O' || chr == 'U';
    }

    public static void main(String[] args) {
        String input = "hello";
        Solution solution = new Solution();
        String result = solution.reverseVowels(input);
        System.out.println(result);
    }
}