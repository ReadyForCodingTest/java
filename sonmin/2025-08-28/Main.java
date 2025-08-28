package day0527;

import java.io.*;
import java.util.*;

public class Bj27211 {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy= {1,0,-1,0};
    static int[] dx= {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        int count=0;
		for (int i = 0; i < N; i++) 
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) 
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) 
		{
			for (int j = 0; j < M; j++) 
			{
				if(map[i][j]==0&&!visited[i][j])
				{
					visited[i][j]=true;
					bfs(j,i);
					count++;
				}
			}
		}
        System.out.println(count);
    }
    static void bfs(int x, int y) {
    	Queue<int[]> queue = new LinkedList<>();
    	queue.add(new int[] {x,y});
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int now_x = now[0];
			int now_y = now[1];
			for (int i = 0; i < 4; i++) {
				int new_x = now_x + dx[i];
				int new_y = now_y + dy[i];
				if (new_x < 0 )
				{
					new_x=M-1;
				}
				if (new_y < 0 )
				{
					new_y=N-1;
				}
				if (new_x >= M ) {
					new_x=0;
				}
				if (new_y >= N) {
					new_y = 0;
				}
				
				if (!visited[new_y][new_x] && map[new_y][new_x] == 0)
				{
					visited[new_y][new_x] = true;
					queue.add(new int[] { new_x, new_y });
				}
				
			}
		}
    }
}
