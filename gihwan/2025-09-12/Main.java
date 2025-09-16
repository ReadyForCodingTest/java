import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String,Integer> dic = new HashMap();
        List<Integer> answerArr = new ArrayList<>();

        for(char c = 'A'; c <= 'Z'; c++){
            dic.put(Character.toString(c), dic.size() + 1);
        }

        int mainIdx = 0;
        while(mainIdx < msg.length()){
            String w = String.valueOf(msg.charAt(mainIdx));
            for(int i = mainIdx + 1; i <= msg.length(); i++) {
                String word = msg.substring(mainIdx, i);
                if (dic.containsKey(word)) {
                    w = word;
                } else {
                    dic.putIfAbsent(word, dic.size() + 1);
                    break;
                }
            }
            answerArr.add(dic.get(w));
            mainIdx += w.length();
        }

        int[] answer = new int[answerArr.size()];
        for(int i = 0; i < answerArr.size(); i++){
            answer[i] = answerArr.get(i);
        }

        return answer;
    }
}