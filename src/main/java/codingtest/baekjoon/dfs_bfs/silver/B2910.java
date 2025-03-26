package codingtest.baekjoon.dfs_bfs.silver;

import java.io.*;
import java.util.*;

public class B2910 {
    static int n, c;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(st.nextToken());
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        List<Pair> pairList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pairList.add(new Pair(entry.getKey(), entry.getValue()));
        }

        pairList.sort((p1, p2) -> p2.cnt - p1.cnt);
        StringBuilder sb = new StringBuilder();
        for (Pair pair : pairList) {
            for (int i = 0; i < pair.cnt; i++) {
                sb.append(pair.num).append(" ");
            }
        }

        String ret = sb.toString().trim();
        System.out.println(ret);


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
