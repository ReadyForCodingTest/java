class Solution {
    public String solution(int[] food) {
        StringBuilder left = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int cnt = food[i] / 2;
            for (int k = 0; k < cnt; k++) {
                left.append(i);
            }
        }

        String leftStr = left.toString();
        String rightStr = new StringBuilder(leftStr).reverse().toString();

        return leftStr + "0" + rightStr;
    }
}
