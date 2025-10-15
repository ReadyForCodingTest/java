
import java.io.*;
import java.util.*;

public class bj1715 {
    static long[] arr;
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer=0;
        arr = new long[N];
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(br.readLine());
            pq.add(arr[i]);
        }
        Arrays.sort(arr);
        while(pq.size() > 1) {
            long a = pq.poll();
            long b = pq.poll();
            pq.add(a+b);
            answer+=a+b;
            
        }
        System.out.println(answer);
    }
}
