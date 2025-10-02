import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold5_13549_retry {
    static class Node implements Comparable<Node> {
        int v, c;

        Node(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }
    }

    static List<List<Node>> graph;
    static int[] dist;
    static final int INF = 100001;

    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= 100000; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Node(1, 1));
        for (int i = 0; i <= 100000; i++) {
            if (i > 0) graph.get(i).add(new Node(i - 1, 1));
            if (i < 100000) graph.get(i).add(new Node(i + 1, 1));
            if (i * 2 <= 100000) graph.get(i).add(new Node(i * 2, 0));
        }

        dijkstra(N);

        System.out.println(dist[K]);

    }

    static void dijkstra(int start) {
        dist = new int[100001];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curV = cur.v;
            int curC = cur.c;

            if (curC > dist[curV]) continue;

            for (Node next : graph.get(cur.v)) {
                int nextV = next.v;
                int nextC = dist[cur.v] + next.c;

                if (nextC < dist[nextV]) {
                    dist[nextV] = nextC;
                    pq.offer(new Node(nextV, nextC));
                }
            }
        }
    }

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{N, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
        }
    }
}
