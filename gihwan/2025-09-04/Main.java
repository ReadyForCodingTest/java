/**
 * 프로그래머스 - 최솟값 만들기
 */
import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        ArrayList<Integer> newA = new ArrayList<Integer>();
        ArrayList<Integer> newB = new ArrayList<Integer>();
        for(int i = 0; i < A.length; i++){
            newA.add(A[i]);
            newB.add(B[i]);
        }
        Collections.sort(newA);
        Collections.sort(newB, Collections.reverseOrder());

        for(int i = 0; i < A.length; i++){
            int mul = newA.get(i) * newB.get(i);
            answer += mul;
        }

        return answer;
    }
}

/*
import java.util.Arrays;
import java.util.Collections;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Integer[] BArr = Arrays.stream(B).boxed().toArray(Integer[]::new); // 이 부분만 바꾸면 될듯?

        Arrays.sort(A);
        Arrays.sort(B);
for(int i = 0; i < B.length/2; i++) {
    int temp = B[i];
    B[i] = B[B.length-1-i];
    B[B.length-1-i] = temp;
}

        for(int i =0; i < A.length; i++){
            answer += A[i] * B[i];
        }

        return answer;
    }
}
 */