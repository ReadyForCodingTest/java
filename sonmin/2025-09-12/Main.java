import java.util.*;
//abcdefghijklmnopqrstu
class Solution {
    static int[][] map;
    static int[] dy = {0,-1,1,0};
    static int[] dx = {1,0,0,-1};
    static String s = "dlru";
    static int n2, m2, x2, y2, r2, c2, k2;
    static int count = 0;
    static String result = "";
    static boolean found = false;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        n2 = n;
        m2 = m;
        x2 = x-1;
        y2 = y-1;
        r2 = r-1; 
        c2 = c-1;
        k2 = k;
        map = new int[n][m];
        
        int dis = man(x2,y2,r2,c2);
        if(dis > k2 || (k2 - dis) % 2 != 0) return "impossible";
  
        bfs(x2, y2, "");
        
        if(found) return result;
        
        return "impossible";
    }
    static void bfs(int now_x, int now_y, String answer) {
        if(count == k2) {
            if(now_x == r2 && now_y == c2) {
                result = answer;
                found = true;
            }
            return;
        }
        
        if(found) return;
        
        for(int i=0;i<4;i++) {
            int new_x = dx[i] + now_x;
            int new_y = dy[i] + now_y;
            
            if(gaji(new_x, new_y)) {
                char c = s.charAt(i);
                count++;
                bfs(new_x, new_y, answer + c);
                count--;
            }
        }
    }
    
    static boolean gaji(int x, int y) {
        if(x < 0 || x >= n2 || y < 0 || y >= m2) return false;
        int dis = man(x,y,r2,c2);
        int count2 = k2 - count - 1;    
        if(dis > count2 || (count2 - dis) % 2 != 0) return false;
        return true;
    }
    
    static int man(int x, int y, int x2, int y2)
    {
        return Math.abs(x - x2) + Math.abs(y - y2);
    }
}