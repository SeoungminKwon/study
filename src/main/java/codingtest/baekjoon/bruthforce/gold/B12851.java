package codingtest.baekjoon.bruthforce.gold;

import java.io.*;
import java.util.*;

public class B12851 {
    static int n, m;
    static final int MAX = 200_000;
    static long[] visited = new long[MAX + 4];
    static long[] cnt = new long[MAX + 4];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

//        if (n == m) {
//            System.out.println(0);
//            System.out.println(1);
//            return;
//        }

        visited[n] = 1;
        cnt[n] = 1;
        Queue<Integer> q = new LinkedList<>();

        q.add(n);

        while (!q.isEmpty()) {
            int now = q.poll();
            int[] directions = {now - 1, now + 1, now * 2};

            for (int next : directions) {
                if (next < 0 || next >= MAX) {
                    continue;
                }

                if (visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    cnt[next] += cnt[now];
                    q.add(next);
                } else if (visited[next] == visited[now] + 1) {
                    cnt[next] += cnt[now];
                }
            }
        }

        System.out.println(visited[m] - 1);
        System.out.println(cnt[m]);


    }
}
