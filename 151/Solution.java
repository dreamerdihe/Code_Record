import java.util.*;

public class Solution {
    public String reverseWords(String s) {
        String[] string = s.trim().split(" +");
        Collections.reverse(Arrays.asList(string));
        return String.join(" ", string);        
    }

    public static void main(String[] args) {
        String input = "look";
        Solution solution = new Solution();
        String result = solution.reverseWords(input);

        System.out.println(result);
    }
}