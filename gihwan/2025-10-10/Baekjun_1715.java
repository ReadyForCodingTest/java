import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjun_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int total = 0 ;
        while(pq.size() > 1) {
            int n1 = pq.poll();
            int n2 = pq.poll();

            total = total + n1 + n2;
            pq.add(n1 + n2);
        }

        System.out.println(total);
    }
}