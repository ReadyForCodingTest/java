// 1~n까지 약수 세서 저장
// limit 넘으면, ++power
// 약수 구하는 부분에서 시간초과나서, 효율적인 방법 참고했습니다
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] list = new int[number];
        int cnt, N;
        for(int i=0; i<number; i++){
            cnt = 0;
            N = i+1;
            // for(int k = 1; k <= N; k++) {
            //     if(N%k == 0) cnt++;
            // }
            for(int k = 1; k*k <=N ; k++) {
                if(k*k == N) cnt++;
                else if ( N % k == 0) cnt+=2;
            }
            list[i] = cnt;
        }

        for(int i=0; i<number; i++){
            if(list[i] > limit) answer += power;
            else answer += list[i];
        }

        return answer;
    }
}