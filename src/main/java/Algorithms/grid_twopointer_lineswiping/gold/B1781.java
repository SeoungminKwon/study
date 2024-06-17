package Algorithms.grid_twopointer_lineswiping.gold;

import java.io.*;
import java.util.*;

public class B1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Pair> v = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            v.add(new Pair(a, b));
        }
        v.sort(Comparator.comparingInt(p -> p.deadline));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 0;
        for (Pair p : v) {
            result += p.cup;
            pq.offer(p.cup);
            if (pq.size() > p.deadline) {
                result -= pq.poll();
            }
        }
        System.out.println(result);
    }

    static class Pair {
        int deadline;
        int cup;

        public Pair(int deadline, int cup) {
            this.deadline = deadline;
            this.cup = cup;
        }
    }
}
