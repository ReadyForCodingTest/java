/**
매일 들어오는 점수를 받아서 “상위 k개만 유지”
가장 작은 값(= k번째 순위 점수) 을 발표

-> 현재까지의 상위 k명 점수 중 최솟값

우선순위큐
우선순위가 높은게 가장 먼저 나온다

오름차순 (작은게 우선순위 높다)
*/
import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> board = new PriorityQueue<>();
        int[] answer = new int[score.length];
        
        for(int i = 0; i <score.length; i++) {
            board.offer(score[i]);
            if(board.size()>k) {
                board.poll(); //K 초과시 제거
            }
            answer[i] = board.peek();
        }
        return answer;
    }
}
