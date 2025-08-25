import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;

        Deque<Integer> queue = new ArrayDeque<>();

        for (int n : arr) {
            if (queue.isEmpty() || queue.peekLast() != n) {
                queue.offer(n);
            }
        }

        answer = new int[queue.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = queue.poll();
        }

        return answer;
    }
}