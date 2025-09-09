import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        for (int j = 0; j < n; j++) 
        {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            boolean isValid = true;
            for (int i = 0; i < n; i++) 
            {
                char temp = s.charAt((j + i) % n); 
                if (temp == '{' || temp == '[' || temp == '(') stack.push(temp);
                else 
                {
                    if (stack.isEmpty()) 
                    {
                        isValid = false;
                        break;
                    }
                    char top = stack.peek();
                    if ((temp == '}' && top == '{') ||(temp == ']' && top == '[') ||
                        (temp == ')' && top == '(')) stack.pop();
                    else 
                    {
                        isValid = false;
                        break;
                    }
                }
            }
            if (isValid && stack.isEmpty()) answer++;
        }
        return answer;
    }
}
