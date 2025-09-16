class Solution {
    public int solution(String word) {
        int answer = 0;
        char[] arr = {'0','0','0','0','0'};
        for(int i =0; i < word.length(); i++){
            arr[i] = word.charAt(i);
        }

        int[] weights = new int[5];
        weights[4] = 1;
        for (int i = 3; i >= 0; i--) {
            weights[i] = weights[i+1] * 5 + 1; // [781, 156, 31, 6, 1] -> 각 자리수의 알파벳이 바뀔 때 까지의 수
        }

        for(int i = 0; i < 5; i++){

            switch(arr[i]){
                case 'A':{
                    answer += weights[i] * 0;
                    break;
                }
                case 'E':{
                    answer += weights[i] * 1;
                    break;
                }
                case 'I':{
                    answer += weights[i] * 2;
                    break;
                }
                case 'O':{
                    answer += weights[i] * 3;
                    break;
                }
                case 'U':{
                    answer += weights[i] * 4;
                    break;
                }
                default: break;
            }
        }
        answer += word.length();
        return answer;
    }
}