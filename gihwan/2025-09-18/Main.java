import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inoutMap = new HashMap<>(); // "차량번호", 주차시각
        Map<String, Integer> answerMap = new TreeMap<>(); // "차량번호", 주차시간 -> 차량번호 기준 오름차순 정렬

        for(int i = 0; i < records.length; i++){
            String[] curInfo = records[i].split(" "); // "입차시각" , "차량번호", "입출차 여부"
            String[] time = curInfo[0].split(":");
            int ttm = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            if(curInfo[2].equals("IN")){
                inoutMap.put(curInfo[1], ttm);
            } else{
                int parkingTime = ttm - inoutMap.remove(curInfo[1]);
                if(answerMap.get(curInfo[1]) == null){
                    answerMap.put(curInfo[1], parkingTime);
                } else{
                    int totalTime = answerMap.get(curInfo[1]) + parkingTime;
                    answerMap.replace(curInfo[1], totalTime);
                }
            }
        }

        // 출차 23:59
        Iterator<String> iterator = inoutMap.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            int iterTime = inoutMap.get(key);
            int parkingTime = 23 * 60 + 59 - iterTime;
            if(answerMap.get(key) == null){
                answerMap.put(key, parkingTime);
            } else{
                int totalTime = answerMap.get(key) + parkingTime;
                answerMap.replace(key, totalTime);
            }
            iterator.remove();
        }

        // 요금 정산
        // 기본 시간, 기본 요금, 단위 시간, 단위 요금
        int[] answer = new int[answerMap.size()];
        Iterator<String> iterAnswer = answerMap.keySet().iterator();
        int idx = 0;
        while(iterAnswer.hasNext()){
            String key = iterAnswer.next();
            if(answerMap.get(key) - fees[0] <= 0){
                answer[idx] = fees[1];
            } else{
                int time = answerMap.get(key) - fees[0];
                int q = time / fees[2];
                int r = time % fees[2];
                if(r != 0) answer[idx] = fees[1] + fees[3] * (q + 1);
                else answer[idx] = fees[1] + fees[3] * q;
            }
            idx++;
        }

        return answer;
    }
}