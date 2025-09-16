import java.util.*;

class Solution {
    public int[] solution(String msg) {

        Map<String, Integer> dict = new HashMap<>();
        for(int i = 0; i< 26; i++){
            String str = String.valueOf((char)('A' + i));
            dict.put(str , i+1);
        }
        int nextIndex = 27;

        ArrayList<Integer> result = new ArrayList<>();

        // 현재 입력이 사전에 있는지 조회
        // W+C 단어가 존재하면 W , C 갱신하고, 다음루프
        int i = 0;
        while (i < msg.length()) {

            StringBuilder sb = new StringBuilder();
            String W = "";
            int j = i;

            while (j < msg.length()) {
                sb.append(msg.charAt(j));
                if (dict.containsKey(sb.toString())) {
                    W = sb.toString();
                    j++;
                } else {
                    break;
                }
            }
            result.add(dict.get(W)); // index

            if (j < msg.length()) {
                String C = String.valueOf(msg.charAt(j));
                dict.put(W + C, nextIndex++);
            }
            i += W.length();
        }

        int[] answer = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            answer[k] = result.get(k);
        }

        return answer;
    }
}