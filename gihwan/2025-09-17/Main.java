import java.util.*;
class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] cpMap;
    static Point start;
    static Point lever;
    static Point exit;
    public int solution(String[] maps) {
        int answer = 0;
        cpMap = new char[maps.length][maps[0].length()];

        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                char c = maps[i].charAt(j);
                cpMap[i][j] = c;
                switch(c){
                    case 'S' : start = new Point(j,i); break;
                    case 'E' : exit = new Point(j,i); break;
                    case 'L' : lever = new Point(j,i); break;
                    default : break;
                }
            }
        }

        int ttl = BFS(start, lever);
        if(ttl == -1) return -1;
        int tte = BFS(lever, exit);
        if (tte == -1) return -1;

        answer = ttl + tte;
        return answer;

    }

    public static int BFS(Point startPoint, Point destPoint){
        Queue<Point> q = new LinkedList<>();
        int[][] distance = new int[cpMap.length][cpMap[0].length];
        for(int i = 0; i < cpMap.length; i++){
            Arrays.fill(distance[i], -1);
        }
        distance[startPoint.y][startPoint.x] = 0;
        q.offer(startPoint);

        while(!q.isEmpty()){
            Point cur = q.poll();
            if (cur.x == destPoint.x && cur.y == destPoint.y) {
                return distance[cur.y][cur.x];
            }

            for(int i = 0; i < 4; i++){
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];
                if(newX >= 0 && newX < cpMap[0].length && newY >= 0 && newY < cpMap.length && distance[newY][newX] == -1 && cpMap[newY][newX] != 'X'){
                    q.offer(new Point(newX, newY));
                    distance[newY][newX] = distance[cur.y][cur.x] + 1;
                }
            }
        }
        return -1;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}