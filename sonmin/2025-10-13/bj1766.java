import java.io.*;
import java.util.*;

public class bj1766 {
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[N+1];
        for(int i=0;i<=N;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int i=1;i<=M;i++)
        {
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            indegree[b]++;
        }
        // for(int i=1;i<=N;i++)
        // {
        //     Collections.sort(graph.get(i));
        // }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1;i<=N;i++)
        {
            if(indegree[i]==0)
            {
                pq.add(i);
            }
        }
        while(!pq.isEmpty())
        {
            int now = pq.poll();
            System.out.print(now+" ");
            for(int next : graph.get(now))
            {
                indegree[next]--;
                if(indegree[next]==0)
                {
                    pq.add(next);
                }
            }
        }
        
        
        
    }
}
