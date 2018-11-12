import java.util.*;

class Solution {
    public void reverseWords(char[] str) {
        int end = 0;
        while(end < str.length) {
            int start = end;
            while(str[end] != ' ') {
                end ++;
                if(end == str.length) {
                    break;
                }
            }

            reverse(str, start, end);
            end ++;
        }

        Collections.reverse(Arrays.asList(str));

    }

    private static void reverse(char[] str, int start, int end) {
        int l = start;
        int r = end - 1;
        while(l < r) {
            char temp = str[l];
            str[l] = str[r];
            str[r] = temp;
            l ++;
            r --;
        }
    }

    public static void main(String[] args) {
        char[] input = {'a', 'b', ' ', 'c'};
        Solution solution = new Solution();
        solution.reverseWords(input);
        System.out.println(input);
    }
}