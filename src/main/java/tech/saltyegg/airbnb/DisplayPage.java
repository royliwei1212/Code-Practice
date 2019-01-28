package tech.saltyegg.airbnb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class DisplayPage {

    public List<Entry> pagination(List<Entry> input, int pageSize) {
        if (input == null || pageSize >= input.size() || pageSize < 2) {
            return input;
        }

        Queue<Entry> queue = new LinkedList<>(input);
        Queue<Entry> paraQueue = new LinkedList<>();
        List<Entry> result = new ArrayList<>();

        Set<Integer> visitedHostId = new HashSet<>();

        while (!queue.isEmpty() || !paraQueue.isEmpty()) {
            List<Entry> out = new ArrayList<>(pageSize);

            while (out.size() < pageSize && (!queue.isEmpty() || !paraQueue.isEmpty())) {
                visitedHostId.clear();
                Queue<Entry> tmp = new LinkedList<>();
                while (!paraQueue.isEmpty()) {
                    queueShift(pageSize, paraQueue, tmp, visitedHostId, out);
                }
                paraQueue = tmp;
                while (!queue.isEmpty() && out.size() < pageSize) {
                    queueShift(pageSize, queue, paraQueue, visitedHostId, out);
                }
            }
            result.addAll(out);
        }
        return result;
    }

    private void queueShift(int pageSize, Queue<Entry> queue, Queue<Entry> paraQueue, Set<Integer> visitedHostId, List<Entry> out) {
        Entry e = queue.poll();
        if (!visitedHostId.contains(e.hostId) && out.size() < pageSize) {
            out.add(e);
            visitedHostId.add(e.hostId);
        } else {
            paraQueue.add(e);
        }
    }


    static class Entry {
        int hostId;
        int listingId;
        double score;
        String city;

        Entry(int hostId, int listingId, double score, String city) {
            this.hostId = hostId;
            this.listingId = listingId;
            this.score = score;
            this.city = city;
        }

        public String toString() {
            return hostId + " - " + listingId + " - " + score + " - " + city;
        }
    }

    private static List<Entry> getTestInput() {
        List<Entry> input = new LinkedList<>();
        input.add(new Entry(1, 28, 310.6, "SF"));
        input.add(new Entry(4, 5, 204.1, "SF"));
        input.add(new Entry(20, 7, 203.2, "Oakland"));
        input.add(new Entry(6, 8, 202.2, "SF"));
        input.add(new Entry(6, 10, 199.1, "SF"));
        input.add(new Entry(1, 16, 190.4, "SF"));
        input.add(new Entry(6, 29, 185.2, "SF"));
        input.add(new Entry(7, 20, 180.1, "SF"));
        input.add(new Entry(6, 21, 162.1, "SF"));
        input.add(new Entry(2, 18, 161.2, "SF"));
        input.add(new Entry(2, 30, 149.1, "SF"));
        input.add(new Entry(3, 76, 146.2, "SF"));
        input.add(new Entry(2, 14, 141.1, "San Jose"));
        return input;
    }

    public static void main(String[] args) {
        DisplayPage dp = new DisplayPage();
        int pageSize = 5;
        List<Entry> out = dp.pagination(getTestInput(), pageSize);
        int index = 0;
        for (Entry e : out) {
            if (index++ % pageSize == 0) {
                System.out.println();
            }
            System.out.println(e);
        }
    }
}
