import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjun_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] liquid = new int[N];

        int num1 = 0;
        int num2 = 0;
        int left = 0;
        int right = N-1;
        int min = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        if(liquid[0] >= 0) {
            num1 = liquid[0];
            num2 = liquid[1];
        } else if(liquid[N - 1] <= 0) {
            num1 = liquid[N - 2];
            num2 = liquid[N - 1];
        } else{
            while(left < right){
                int sum = liquid[left] + liquid[right];
                int abs = Math.abs(sum);
                if(abs < min){
                    min = abs;
                    num1 = liquid[left];
                    num2 = liquid[right];
                }

                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(num1 + " " + num2);
    }
}
