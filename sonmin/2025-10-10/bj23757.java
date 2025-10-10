import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj23757 {
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> b - a);
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) pq1.add(Integer.parseInt(st.nextToken()));
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) pq2.add(Integer.parseInt(st.nextToken()));
        
        while(!pq2.isEmpty())
        {
            if(!pq1.isEmpty())
            {
                if(pq1.peek()>=pq2.peek())
                {
                    int a = pq1.poll();
                    int b = pq2.poll();
                    if(b-a>=1) pq2.add(b-a);
                }
                else
                {
                    System.out.println("0");
                    return;
                }
            }
            else
            {
                System.out.println("0");
                return;
            }
        }
        System.out.println("1");
    }
}
