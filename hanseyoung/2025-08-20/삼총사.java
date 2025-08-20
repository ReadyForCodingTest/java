/**
삼총사 -> 3명 정수 번호 더했을 때 0
삼총사 가능 방법 찾기

조합으로 3개 뽑기 -> 백트랙킹(dfs)
*/
import java.util.*;
class Solution {
    private int answer;
    
    public int solution(int[] number) {
        answer = 0;
        dfs(number, 0,0,0);
        return answer;
    }
    
    private void dfs(int[] number, int start, int picked, int sum){
        if(picked ==3){
            if(sum ==0) answer++;
            return;
        }
        for(int i = start; i <number.length; i++) {
            dfs(number,i+1,picked+1, sum+number[i]);
        }
    }

}
