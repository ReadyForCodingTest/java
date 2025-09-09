import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        StringBuilder sb = new StringBuilder(s);

        for(int i =0; i < s.length(); i++){

            if(check(sb)) answer++;
            char ch = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(ch);

        }

        return answer;

    }

    static boolean check(StringBuilder str){
        Stack<Character> stack = new Stack<>();
        String st = str.toString();
        char[] list = st.toCharArray();
        for( char c : list ) {
            if(c == ']' || c == ')' || c == '}') {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if((c == ')' && top != '(') ||(c == ']' && top != '[') ||(c == '}' && top != '{')) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();

    }

}