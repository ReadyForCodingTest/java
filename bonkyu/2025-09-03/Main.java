import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {

        Arrays.sort(people);
        int cnt = 0;
        int i = 0;
        int k = people.length - 1;

        // 최대 2명
        // 무거운사람 + 가벼운사람
        while (i <= k) {
            if (people[i] + people[k] <= limit ) {
                i++;
            }
            k--;
            cnt++;
        }
        return cnt;
    }
}