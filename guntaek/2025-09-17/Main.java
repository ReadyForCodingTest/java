import java.util.*;
class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] miro;
    static boolean[][] visited;

    static int n, m;
    static int xStart, yStart;
    static int xLever, yLever;
    static int xExit, yExit;

    public int solution(String[] maps) {
        int answer = 0;

        n = maps.length;
        m = maps[0].length();

        miro = new char[n][m];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                miro[i][j] = maps[i].charAt(j);

                if (miro[i][j] == 'S') {
                    xStart = i;
                    yStart = j;
                } else if (miro[i][j] == 'L') {
                    xLever = i;
                    yLever = j;
                } else if (miro[i][j] == 'E') {
                    xExit = i;
                    yExit = j;
                }
            }
        }

        answer = escape();

        return answer;
    }

    static int escape() {
        visited = new boolean[n][m];

        int findLeverTime = 0;
        boolean findLever = false;

        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] {xStart, yStart, 0});
        visited[xStart][yStart] = true;

        while (!queue.isEmpty()) {
            if (findLever) break;

            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && miro[nx][ny] != 'X' && !visited[nx][ny]) {
                    if (miro[nx][ny] == 'L') {
                        findLeverTime = cur[2] + 1;
                        findLever = true;
                        break;
                    }
                    queue.offer(new int[] {nx, ny, cur[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }

        visited = new boolean[n][m];

        int findExitTime = 0;
        boolean findExit = false;

        queue = new ArrayDeque<>();

        queue.offer(new int[] {xLever, yLever, 0});
        visited[xLever][yLever] = true;

        while (!queue.isEmpty()) {
            if (findExit) break;

            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && miro[nx][ny] != 'X' && !visited[nx][ny]) {
                    if (miro[nx][ny] == 'E') {
                        findExitTime = cur[2] + 1;
                        findExit = true;
                        break;
                    }
                    queue.offer(new int[] {nx, ny, cur[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }

        if (findLever && findExit) {
            return findLeverTime + findExitTime;
        } else {
            return -1;
        }
    }
}





