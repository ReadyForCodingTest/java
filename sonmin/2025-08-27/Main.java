class Solution {
    static int limit1, power1;
    public int solution(int number, int limit, int power) {
        int answer = 0;
        limit1 = limit;
        power1 = power;
        for(int i=1;i<=number;i++)
        {
            int temp = func(i);
            if(temp>limit) temp=power;
            answer+=temp;
            System.out.println(temp);
        }
        return answer;
    }
    static int func(int num)
    {
        int count=0;
        for(int i=1; i*i<=num;i++)
        {
            if(num%i==0)
            {
                if(i*i!=num)
                {
                    count+=2;
                    if(count>limit1) return power1;
                }
                else
                {
                    count+=1;
                    if(count>limit1) return power1;
                }
            }
        }
        return count;
    }
}