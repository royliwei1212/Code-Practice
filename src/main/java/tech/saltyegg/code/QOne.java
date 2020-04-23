package tech.saltyegg.code;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class QOne {

    public static int process(int num, List<Integer> list) {
        if (num < 1 || list.size() < num) return 0;
        if (num == 1) return list.get(0);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < num; i++) {
            pq.add(list.get(i));
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                return sum;
            }

            int a = pq.poll();
            int b = pq.poll();
            sum += a + b;
            pq.add(a + b);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(process(1, Arrays.asList(8, 9)));
        System.out.println(process(4, Arrays.asList(20, 4, 8, 2)));
        System.out.println(process(6, Arrays.asList(1, 2, 5, 10, 35, 89)));
    }
}
