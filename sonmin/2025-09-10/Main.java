import java.util.*;
class Solution {
    static ArrayList<String> list = new ArrayList<String>();
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        for(int i=0; i<cities.length;i++)
        {
            String s = cities[i].toLowerCase();
            
            if(cacheSize==0) return 5*cities.length;
            if(list.contains(s))
            {
                
                list.remove(s);
                list.add(s);
                answer+=1;
            }
            else
            {
                if(list.size()>=cacheSize) list.remove(0);
                list.add(s);
                answer+=5;
            }
        }
        return answer;
    }
}