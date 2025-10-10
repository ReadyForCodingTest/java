import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj11000 {
    static class Lecture implements Comparable<Lecture>
    {
        int start;
        int end;
        public Lecture(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Lecture o)
        {
            if(this.start == o.start)
            {
                return this.end - o.end;
            }
            else
            {
                return this.start - o.start;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Lecture[] lectures = new Lecture[N];
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(m,n);
        }
        Arrays.sort(lectures);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0].end);
        for(int i=1;i<N;i++)
        {
            if(!pq.isEmpty())
            {
                if(pq.peek()<=lectures[i].start)
                {
                    pq.poll();
                }
                pq.add(lectures[i].end);
            }
        }
        System.out.println(pq.size());
    }
}
