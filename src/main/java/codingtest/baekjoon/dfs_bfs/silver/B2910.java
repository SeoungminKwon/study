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
            int temp = Integer.parseInt(st.nextToken());
            int value = map.getOrDefault(temp, 0);
            map.put(temp, value + 1);
        }

        List<Pair> pairList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pairList.add(new Pair(entry.getKey(), entry.getValue()));
        }

        Collections.sort(pairList, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) {
                return p2.cnt - p1.cnt;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Pair p : pairList) {
            for (int i = 0; i < p.cnt; i++) {
                sb.append(p.number).append(" ");
            }
        }

        System.out.println(sb.toString().trim());


    }
    static class Pair{
        int number;
        int cnt;

        Pair(int number, int cnt) {
            this.number = number;
            this.cnt = cnt;
        }
    }
}
