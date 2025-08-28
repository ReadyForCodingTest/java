import java.util.*;

// NXM 상하좌우 이동
// 1이면 숲으로 막혀있음
// 탐험 할 수 있는 구역의 갯수
// 0으로 이뤄진 구역을 한바퀴 돌아 이동 가능하면 같은 구역으로 봄
// 기본 bfs로 구역 탐색하고, 같은 구역만큼 빼기?
public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

    }

    static void bfs(int i, int j) {
        Queue<Integer> queue = new LinkedList<>();

    }
}