import java.util.*;

public class Solution {
    static Deque<Integer> stack = new LinkedList<>();
    public int[] solution(int []arr) {
        
        for(int i=0;i<arr.length;i++)
        {
            if(stack.isEmpty()) stack.push(arr[i]);
            if(arr[i]!=stack.peek())
            {
                stack.push(arr[i]);
            }
        }
        int[] answer = new int[stack.size()];
        for(int i=0;i<answer.length;i++)
        {
            answer[i]=stack.pollLast();
        }
        return answer;
    }
}