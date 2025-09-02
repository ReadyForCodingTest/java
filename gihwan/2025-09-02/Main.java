/**
 프로그래머스 - Lv1. 푸드파이트

 **/
class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        // 절반
        for(int i=1; i<food.length; i++) {
            for(int j=0; j < food[i] / 2; j++){
                sb.append(i);
            }
        }
        // 앞,뒤
        String front = sb.toString();
        String back = sb.reverse().toString();

        answer = front + "0" + back;
        return answer;
    }
}