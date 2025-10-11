import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj2056 {
    static int[] indegree;
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        time = new int[N+1];
        indegree = new int[N+1];
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            for(int k=0; k<count;k++)
            {
                int a =Integer.parseInt(st.nextToken());
                graph.get(i).add(a);
                indegree[a]++;
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
        for (int i = 1; i <= N; i++) answer = Math.max(answer, dp[i]);
        System.out.println(answer);
    }
}
