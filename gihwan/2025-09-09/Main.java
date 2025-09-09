import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(String s) {
        int answer = 0;

        Outter : // 몰랐던 부분
        for (int i = 0; i < s.length(); i++) {
            String newS = s.substring(i) + s.substring(0, i);

            char first = newS.charAt(0);
            char last = newS.charAt(newS.length() - 1);
            if (first == ')' || first == '}' || first == ']' ||
                    last == '(' || last == '{' || last == '[') continue;

            Deque<Character> stack = new ArrayDeque<>();

            for(char c : newS.toCharArray()) {
                switch (c){
                    case '(': stack.addLast(')'); break;
                    case '{': stack.addLast('}'); break;
                    case '[': stack.addLast(']'); break;
                    default: {
                        if(stack.isEmpty() || c != stack.pollLast()) continue Outter;
                    }
                }
            }
            if(stack.isEmpty()) answer++;
        }
        return answer;
    }
}