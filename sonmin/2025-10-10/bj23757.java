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
        int[] arr1 = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) pq1.add(Integer.parseInt(st.nextToken()));
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) arr1[i]=Integer.parseInt(st.nextToken());
        
        for(int i=0;i<M;i++)
        {
            if(!pq1.isEmpty())
            {
                if(pq1.peek()>=arr1[i])
                {
                    int a = pq1.poll();
                    int b = arr1[i];
                    if(a-b>=1) pq1.add(a-b);
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
