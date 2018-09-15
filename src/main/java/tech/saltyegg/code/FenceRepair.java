package tech.saltyegg.code;

import java.util.PriorityQueue;

public class FenceRepair {

    private int solution(int[] input) {
        if (input == null || input.length == 0) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : input) pq.add(i);
        int result = 0;
        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                return result + pq.poll();
            }

            int a = pq.poll();
            int b = pq.poll();
            int c = a + b;
            result += c;
            if (!pq.isEmpty()) pq.add(c);
        }

        return result;
    }

    public static void main(String[] args) {
        FenceRepair fenceRepair = new FenceRepair();
        System.out.println(fenceRepair.solution(new int[]{8, 5, 8}));
    }
}
