import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        List<Integer> list = new ArrayList<>();

        for (int i=0; i<score.length; i++) {
            if (list.size() < k) {
                list.add(score[i]);
                list.sort(Comparator.reverseOrder());
                answer[i] = list.get(list.size() - 1);
                continue;
            }

            for (int j=0; j<k; j++) {
                if (score[i] > list.get(j)) {
                    list.add(j, score[i]);
                }
                answer[i] = list.get(k-1);
            }
        }

        return answer;
    }
}