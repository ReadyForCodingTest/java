import java.util.*;

class Solution {
    static int count = 0;
    static boolean flag = false;
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        String start = "";
        dfs(start, word);
        return count;
    }

    private void dfs(String current, String target) {
        if (flag) {
            return;
        }

        if (current.equals(target)) {
            flag = true;
            return;
        }

        if (current.length() >= 5) {
            return;
        }

        for (int i = 0; i < vowels.length; i++) {
            String next = current + vowels[i];
            count++;
            dfs(next, target);
            if (flag) {
                return;
            }
        }
    }
}