import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int[] numArr;
    public static int targetNum;
    public static int[] mul = {-1, 1};
    public int solution(int[] numbers, int target) {
        numArr = numbers;
        targetNum = target;
        int answer = BFS();
        return answer;
    }

    static int BFS(){
        int count = 0;
        Queue<Node> q = new LinkedList<>();

        for(int i = 0; i < mul.length; i++){
            int curSum = numArr[0] * mul[i];
            q.offer(new Node(curSum, 0));
        }

        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.idx == numArr.length-1){
                if(cur.sum == targetNum){
                    count++;
                }
                continue;
            }

            for(int i=0; i< mul.length; i++){
                int newSum = cur.sum + mul[i]*numArr[cur.idx+1];
                q.offer(new Node(newSum, cur.idx+1));
            }
        }

        return count;
    }

    static class Node{
        int sum;
        int idx;
        public Node(int sum, int idx){
            this.sum = sum;
            this.idx = idx;
        }
    }
}