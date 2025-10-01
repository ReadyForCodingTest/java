class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        int[] server = new int[24 + k];

        for (int i = 0; i < players.length; i++) {
            int need = players[i] / m;
            if (server[i] < need) {
                int additional = need - server[i];
                answer += additional;

                for (int j = i; j < i + k; j++) {
                    server[j] += additional;
                }
            }
        }

        return answer;
    }
}