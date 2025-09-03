/**
 * 프로그래머스 - 구명보트
 * 한번에 최대 2명씩, 무게 제한도 존재
 */
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            answer++;
        }
        return answer;
    }
}