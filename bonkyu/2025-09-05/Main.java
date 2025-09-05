import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int arr1_row = arr1.length;
        int arr1_col = arr1[0].length;
        int arr2_col = arr2[0].length;
        int[][] answer = new int[arr1_row][arr2_col];

        for(int i =0 ; i < arr1_row; i++) { // 0 1 2
            for(int k =0 ; k < arr2_col; k++) {  // 0 1
                for(int j = 0; j < arr1_col; j++) { answer[i][k] += arr1[i][j]*arr2[j][k]; }
            }
        }

        return answer;
    }
}

