class Solution {

    public int solution(int a, int b, int n) {
        int answer = 0;
        int remained = 0;
        // a개 -> b개
        while(n >= a) {
            int new_coke = (n/a) * b;
            answer += new_coke;
            n = (n%a) + new_coke;
        }
        return answer;
    }
}