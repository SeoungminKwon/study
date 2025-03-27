package codingtest.baekjoon.dfs_bfs.silver;

import java.io.*;
import java.util.*;

public class B2910 {

    static int n, c;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        Map<Integer, Integer> map = new LinkedHashMap<>();
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(input[i]);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        List<Pair> pairList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry  :  map.entrySet()){
            pairList.add(new Pair(entry.getKey(), entry.getValue()));
        }

        Collections.sort(pairList, new Comparator<Pair>() {

            public int compare(Pair p1, Pair p2){
                return p2.cnt - p1.cnt;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Pair pair : pairList) {
            for (int i = 0; i < pair.cnt; i++) {
                sb.append(pair.num);
                sb.append(" ");
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
