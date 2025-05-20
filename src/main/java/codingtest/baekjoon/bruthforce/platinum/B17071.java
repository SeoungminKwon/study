package codingtest.baekjoon.bruthforce.platinum;

import java.util.*;
import java.io.*;

public class B17071 {
    static final int MAX = 500_000;
    static int n, m;
    static int[][] visited = new int[2][MAX + 4];
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (n == m) {
            System.out.println(0);
            return;
        }

        visited[0][n] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        boolean found = false;
        int turn = 1;


        while (!q.isEmpty()) {
            m += turn;
            if(m > MAX) break;

            // 동시 도착 체크
            if (visited[turn % 2][m] != 0) {
                found = true;
                break;
            }

            // BFS
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                int current = q.poll();

                for (int next : new int[]{current + 1, current - 1, current * 2}) {
                    if(next < 0 || next > MAX || visited[turn % 2][next] != 0) continue;
                    visited[turn % 2][next] = visited[(turn + 1) % 2][current] + 1;

                    if (next == m) {
                        found = true;
                        break;
                    }

                    q.add(next);
                }

                if(found) break;
            }

            if(found) break;
            turn++;
        }

        System.out.println(found ? turn : -1);
    }
}
