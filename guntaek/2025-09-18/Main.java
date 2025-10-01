import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int baseMin = fees[0];
        int baseFee = fees[1];
        int unitMin = fees[2];
        int unitFee = fees[3];

        Map<String, Deque<String>> map = new TreeMap<>();

        for (String record : records) {
            String[] detail = record.split(" ");

            if (map.containsKey(detail[1])) {
                map.get(detail[1]).offer(detail[0]);
            } else {
                Deque<String> temp = new ArrayDeque<>();
                temp.offer(detail[0]);
                map.put(detail[1], temp);
            }
        }

        List<Integer> list = new ArrayList<>();

        for (Map.Entry<String, Deque<String>> entry : map.entrySet()) {

            Deque<String> queue = entry.getValue();

            int charge = 0;
            int totalTime = 0;

            while (!queue.isEmpty()) {
                String[] in = queue.poll().split(":");

                if (!queue.isEmpty()) {
                    String[] out = queue.poll().split(":");

                    totalTime += (Integer.parseInt(out[0]) * 60 + Integer.parseInt(out[1])) - (Integer.parseInt(in[0]) * 60 + Integer.parseInt(in[1]));
                } else {
                    totalTime += (23 * 60 + 59) - (Integer.parseInt(in[0]) * 60 + Integer.parseInt(in[1]));
                }
            }

            if (totalTime > baseMin) {
                charge += baseFee + Math.ceil((((double)totalTime - baseMin) / unitMin)) * unitFee;
            } else {
                charge += baseFee;
            }

            list.add(charge);
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}