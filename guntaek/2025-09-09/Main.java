import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();

            String rotated = s.substring(i) + s.substring(0, i);

            boolean isValid = true;
            for (char c : rotated.toCharArray()) {
                if (map.containsValue(c))
                    stack.push(c);
                else if (map.containsKey(c)) {
                    if (!stack.isEmpty() && stack.pop() == map.get(c)) {

                    }
                    else {
                        isValid = false;
                        break;
                    }
                }
            }
            if (isValid && stack.isEmpty())
                answer++;
        }
        return answer;
    }
}
