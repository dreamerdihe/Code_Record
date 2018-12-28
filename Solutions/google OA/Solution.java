import java.util.*;
class Solution {
    public int solution(int[] S, int[] E) {
        Arrays.sort(S);
        Arrays.sort(E);

        int chairs = 0;
        int start = 0;
        int end = 0;
        while(start < S.length) {
            if(S[start] < E[end]) {
                chairs ++;
                start ++;
                continue;
            }

            if(S[start] >= E[end]) {
                start ++;
                end ++;
                continue;
            }
        }

        return chairs;
    }

    public static void main(String[] args) {
        int[] S = {0, 5, 15};
        int[] E = {30, 10, 20};
        Solution solution = new Solution();
        int result = solution.solution(S, E);
        System.out.println(result);
    }
}