class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n>=a)
        {
            int temp = n/a;
            n-=temp*a;
            n+=temp*b;
            answer+=temp*b;
        }
        return answer;
    }
}