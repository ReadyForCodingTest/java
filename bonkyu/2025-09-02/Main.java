class Solution {
    public String solution(int[] food) {

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < food.length; i++) {
            int cnt = food[i] / 2;
            for(int k =0; k < cnt; k++) sb.append(i);
        }
        StringBuilder rev_sb = new StringBuilder(sb).reverse();
        sb.append(0);
        sb.append(rev_sb);

        return sb.toString();
    }
}