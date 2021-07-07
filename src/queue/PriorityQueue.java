package queue;/* Raj Kumar Boddupally created on 7/7/2021 inside the package - queue */

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.Queue;

public class PriorityQueue {
    public static void main(String[] args) {
        Queue<Map.Entry<String, Integer>> queue = new java.util.PriorityQueue<>(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        queue.offer(new AbstractMap.SimpleEntry<>("Hello", 10));
        queue.offer((new AbstractMap.SimpleEntry<>("welcome", 200)));
        queue.offer(new AbstractMap.SimpleEntry<>("test", 60));

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

}
