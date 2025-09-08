import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        } // -> (장식, 2), (겉옷, 1)

        // 경우의 수
        int total = 1;
        for(int i : map.values()){
            total *= (i+1);
        }
        answer = total - 1;

        return answer;
    }
}