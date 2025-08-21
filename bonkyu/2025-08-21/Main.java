import java.util.*;
// k번째 이내이면서, 최소점수
// 최소값 갱신하면서 반복
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> temp = new ArrayList<>();
        int min = 2001;
        int min_idx = -1;

        for(int i =0; i< score.length ; i++) {

            if(temp.size() < k){
                temp.add(score[i]);
                if( score[i] < min ) min = score[i];
            } else {
                if(score[i] > min) {
                    temp.remove(Integer.valueOf(min));
                    temp.add(score[i]);
                    min = Collections.min(temp);
                }
            }
            answer[i] = min;
        }

        return answer;
    }
}