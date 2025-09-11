import java.util.LinkedList;
import java.util.List;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0) return (cities.length * 5);
        List<String> cache = new LinkedList<>();

        for(int i =0; i < cities.length; i++){
            String city = cities[i].toLowerCase();
            // 캐시에 남는 자리 + 캐시에 데이터 X
            if(cache.size() < cacheSize && !cache.contains(city)){
                cache.add(city);
                answer += 5;
                continue;
            }

            // 캐시에 남는 자리 + 캐시에 데이터 존재
            if(cache.size() < cacheSize && cache.contains(city)){
                cache.remove(city);
                cache.add(city);
                answer += 1;
                continue;
            }

            // 캐시는 꽉 찼고, 캐시에 이미 데이터가 존재
            if(cache.size() == cacheSize && cache.contains(city)){
                cache.remove(city);
                cache.add(city);
                answer += 1;
                continue;
            }
            // 캐시는 꽉 찼고, 캐시에도 데이터 존재 X
            if(cache.size() == cacheSize && !cache.contains(city)){
                cache.remove(0);
                cache.add(city);
                answer += 5;
            }
        }

        return answer;
    }
}