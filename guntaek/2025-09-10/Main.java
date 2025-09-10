import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) {
            answer = cities.length * 5;
            return answer;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cities.length; i++) {
            if (map.containsKey(cities[i].toLowerCase())) {
                map.put(cities[i].toLowerCase(), i);
                answer += 1;
            } else {
                if (map.size() < cacheSize) {
                    map.put(cities[i].toLowerCase(), i);
                } else {
                    int min = cities.length;
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        min = Math.min(min, entry.getValue());
                    }
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        if (entry.getValue() == min) {
                            map.remove(entry.getKey().toLowerCase());
                            break;
                        }
                    }
                    map.put(cities[i].toLowerCase(), i);
                }
                answer += 5;
            }
        }

        return answer;
    }
}