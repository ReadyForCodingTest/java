import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjun_13549 {
    static int[] cost = new int[200001];
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;

        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[N] = 0;

        if(N >= K){
            min = N - K;
        } else{
            DIJKSTRA(N);
            min = cost[K];
        }

        System.out.println(min);
    }

    static void DIJKSTRA(int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(n, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.c > cost[cur.v]) continue;

            int np1 = cur.v - 1;
            if(check(np1) && cost[np1] > cur.c + 1) {
                cost[np1] = cur.c + 1;
                pq.add(new Node(np1, cost[np1]));
            }

            int np2 = cur.v + 1;
            if(check(np2) && cost[np2] > cur.c + 1) {
                cost[np2] = cur.c + 1;
                pq.add(new Node(np2, cost[np2]));
            }

            int np3 = cur.v * 2;
            if(check(np3) && cost[np3] > cur.c) {
                cost[np3] = cur.c;
                pq.add(new Node(np3, cost[np3]));
            }
        }
    }

    static boolean check(int v){
        return 0 <= v && v <= 100000;
    }

    static class Node implements Comparable<Node> {
        int v;
        int c;
        public Node(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.c, o.c);
        }
    }
}