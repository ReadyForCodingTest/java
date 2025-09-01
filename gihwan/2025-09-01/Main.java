// 프로그래머스 콜라 문제
// a : 가게에서 필요로 하는 콜라 수
// b : 반환해주는 콜라 수
// c : 내가 갖고 있는 콜라 수
class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a){
            int receive = (n / a) * b;
            int lack = (n % a);
            n = (receive + lack);
            answer += receive;
        }
        return answer;
    }
}