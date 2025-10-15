import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Silver2_16953 {
    static int A, B;
    static int MAX = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        System.out.println(bfs(A));
    }

    static long bfs(int A) {
        Deque<long[]> queue = new ArrayDeque<>();
        queue.offer(new long[]{A, 0});

        while (!queue.isEmpty()) {
            long[] cur = queue.poll();

            if (cur[0] > B) continue;

            if (cur[0] == B) return cur[1] + 1;

            long multiple = cur[0] * 2;
            if (multiple < MAX) {
                queue.offer(new long[]{multiple, cur[1] + 1});
            }

            long concat =  Long.parseLong(cur[0] + "1");
            if (concat < MAX) {
                queue.offer(new long[]{concat, cur[1] + 1});
            }
        }

        return -1;
    }
}