package re.backjun.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pairs.add(new Pair(a, b));
        }

        pairs.sort(Comparator.comparingInt(p -> p.deadLine));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ret = 0;
        for (Pair pair : pairs) {
            ret += pair.cup;
            pq.offer(pair.cup);
            if (pq.size() > pair.deadLine) {
                ret -= pq.poll();
            }
        }
        System.out.println(ret);
    }
    static class Pair{
        int deadLine;
        int cup;

        public Pair(int deadLine, int cup) {
            this.deadLine = deadLine;
            this.cup = cup;
        }
    }
}
