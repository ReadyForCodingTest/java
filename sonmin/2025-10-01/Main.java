import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main  {
    static int N, M;
    static Queue<int[]> queue = new LinkedList<int[]>();
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        visited = new boolean[100002];
        System.out.println(bfs(N, 0));
    }
    
    static int bfs(int now, int count) {
        queue.add(new int[] {now, count});
        visited[now] = true;     
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int time = cur[1];
            if (pos == M) {
                return time;
            }
            int[] nexts = {  pos * 2,pos - 1, pos + 1 };
            for (int next : nexts) 
            {
                if (next >= 0 && next <= 100000 && !visited[next]) 
                {
                    visited[next] = true;
                    if (next == pos * 2) 
                    {
                        queue.add(new int[] {next, time});
                    } 
                    else 
                    {
                        queue.add(new int[] {next, time + 1}); 
                    }
                }
            }
        }
        
        return -1;
    }
}
