class Solution {
    public int solution(String word) {
        int answer = 0;
        int sum=0;
        String a = "AEIOU";
        int[] arr = {3125,625,125,25,5};
        for(int i=0; i<arr.length;i++) sum+=arr[i];
        
        int[] arr2 = new int[5];
        for(int i=0; i<arr.length;i++) arr2[i]=sum/arr[arr.length-i-1];
        for(int i=0; i<word.length();i++)
        {
            char temp = word.charAt(i);
            int index = a.indexOf(temp);
            answer+=arr2[i]*index+1;
        }
        return answer;
    }
}