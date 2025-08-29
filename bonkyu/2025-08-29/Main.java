import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {

        HashSet<Integer> set = new HashSet<>();

        for(int i =0; i< numbers.length - 1; i++) {
            for(int k = i+1; k < numbers.length ; k++) {
                set.add(numbers[i] + numbers[k]);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int[] answer = new int[set.size()];
        for(int i =0; i < set.size(); i++ ) answer[i] = list.get(i);

        return answer;
    }
}