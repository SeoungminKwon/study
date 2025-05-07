package codingtest.baekjoon.bruthforce.gold;

import java.io.*;
import java.util.*;

public class B13913 {
    static int n, m;
    static final int MAX = 200_005;
    static int[] visited = new int[MAX];
    static int[] prev = new int[MAX];
    public static void main(String ars[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        visited[n] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();
            int[] nextDir = {now - 1, now + 1, now * 2};
            if(now == m) break;
            for (int next : nextDir) {
                if(next < 0|| next >= MAX) continue;
                if(visited[next] != 0) continue;

                q.add(next);
                visited[next] = visited[now] + 1;
                prev[next] = now;
            }
        }

        System.out.println(visited[m] - 1);
        List<Integer> ret = new ArrayList<>();
        int path = m;
        ret.add(path);
        while (true) {
            if(path == n) break;
            int temp = prev[path];
            path = temp;
            ret.add(path);
        }
        Collections.reverse(ret);
        StringBuilder sb = new StringBuilder();
        for (int num : ret) {
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
