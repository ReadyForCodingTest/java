import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjun_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        String B = st.nextToken();
        int intB = Integer.parseInt(B);
        int count = 0;

        while(A <= intB){
            count++;
            if(A == intB) break;
            // 짝수인 경우 /2
            if(intB % 2 == 0) {
                intB /= 2;
                B = String.valueOf(intB);
            } else{ // 끝 자리가 1
                if(B.charAt(B.length() - 1) == '1') {
                    B = B.substring(0, B.length() - 1);
                    intB = Integer.parseInt(B);
                } else{ // 끝 자리가 1이 아닌 홀수
                    count = -1; break;
                }
            }
            if(A > intB) {count = -1; break;}
        }

        System.out.println(count);
    }
}
