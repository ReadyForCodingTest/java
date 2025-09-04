class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer;
        answer = new int[arr1.length][arr2[0].length];
        for(int i=0;i<arr1.length;i++)
        {
            for(int j=0;j<arr2[0].length;j++)
            {
                for (int m = 0; m < arr2.length; m++) {
                    answer[i][j] += arr1[i][m] * arr2[m][j];
                } 
            }
        }
        return answer;
    }
}