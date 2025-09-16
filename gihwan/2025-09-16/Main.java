class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[24 + k];

        for (int i = 0; i < players.length; i++) {
            int need = players[i] / m;
            if(server[i] < need ) {
                int plus = need - server[i];
                answer += plus;

                for(int j = i; j < i + k; j++){
                    server[j] += plus;
                }
            }
        }

        return answer;
    }
}