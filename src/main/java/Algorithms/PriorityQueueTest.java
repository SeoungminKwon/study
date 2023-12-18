package Algorithms;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue< Integer > pq = new PriorityQueue<>();
        System.out.println(pq.size());
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        System.out.println(pq.size());
        pq.clear();
        System.out.println(pq.size());

        pq.add(5);
        pq.add(6);
        pq.add(7);
        pq.add(8);

        while (!pq.isEmpty()) {
            Integer i = pq.poll();
            System.out.println(i);
        }
    }
}
