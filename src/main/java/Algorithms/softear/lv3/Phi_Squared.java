package Algorithms.softear.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Phi_Squared {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Pair> behindQ = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            behindQ.addLast(new Pair(Integer.parseInt(st.nextToken()), i + 1));
        }

        while (behindQ.size() > 1) {

            Deque<Pair> frontQ = new LinkedList<>();
            while (!behindQ.isEmpty()) {
                Pair now = behindQ.removeFirst();

                // 앞, 뒤가 now 보다 작을 때
                if (!frontQ.isEmpty()
                            && frontQ.getLast().value <= now.value
                            && !behindQ.isEmpty()
                            && behindQ.getFirst().value <= now.value) {
                    now.value += frontQ.removeLast().value + behindQ.removeFirst().value;
                } else if (!frontQ.isEmpty()
                                   && frontQ.getLast().value <= now.value) {
                    now.value += frontQ.removeLast().value;
                } else if (!behindQ.isEmpty()
                                   && behindQ.getFirst().value <= now.value) {
                    now.value += behindQ.removeFirst().value;
                    String s = "abd";
                    
                }

                frontQ.addLast(now);
            }
            behindQ = frontQ;
        }

        System.out.println(behindQ.getFirst().value);
        System.out.println(behindQ.getFirst().idx);
    }

//    500_000 * 500_000 = 250_000_000_000

    static class Pair{
        long value;
        int idx;

        public Pair(long value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }
}
