import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1516 {
    static int[] indegree;
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        indegree = new int[N+1];
        time = new int[N+1];
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            while(count!=-1)
            {
                graph.get(count).add(i);
                indegree[i]++;
                count = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = time[i];
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for(int i=0; i<graph.get(now).size();i++)
            {
                int next = graph.get(now).get(i);
                dp[next] = Math.max(dp[next],dp[now]+time[next]);
                indegree[next]--;
                if(indegree[next]==0) queue.add(next);
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) System.out.println(dp[i]);
        // System.out.println(answer);
    }
}
