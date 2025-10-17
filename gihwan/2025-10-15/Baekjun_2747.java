import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjun_2747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i <= n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        System.out.println(arr[n]);
    }
}
