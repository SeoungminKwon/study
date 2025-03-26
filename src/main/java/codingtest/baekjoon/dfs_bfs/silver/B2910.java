package codingtest.baekjoon.dfs_bfs.silver;

import java.io.*;
import java.util.*;

public class B2910 {
    static int n, c;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Pair> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new Pair(entry.getKey(), entry.getValue()));
        }

        list.sort((a, b) -> b.cnt - a.cnt);

        StringBuilder sb = new StringBuilder();
        for (Pair pair : list) {
            for (int i = 0; i < pair.cnt; i++) {
                sb.append(pair.num).append(" ");
            }
        }

        System.out.println(sb.toString().trim());

    }

    static class Pair{
        int num;
        int cnt;

        Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
