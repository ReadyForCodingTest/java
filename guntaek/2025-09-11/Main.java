import java.util.*;
class Solution {
    public int solution(String word) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('E', 1);
        map.put('I', 2);
        map.put('O', 3);
        map.put('U', 4);

        int[] weights = {781, 156, 31, 6, 1};

        int answer = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = map.get(ch);

            answer += index * weights[i] + 1;
        }

        return answer;
    }
}