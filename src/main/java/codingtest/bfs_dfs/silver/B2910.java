package codingtest.bfs_dfs.silver;

import java.util.*;
import java.io.*;

public class B2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        Map<Integer, Integer> freq = new LinkedHashMap<>();
        Map<Integer, Integer> firstIdx = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            a[i] = x;

            freq.put(x, freq.getOrDefault(x, 0) + 1);
            if (!firstIdx.containsKey(x)) {
                firstIdx.put(x, i + 1);
            }
        }

        List<int[]> v = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int value = e.getKey();
            int count = e.getValue();
            v.add(new int[]{count, value});
        }

        // 정렬
        v.sort((p1, p2) -> {
            int cnt1 = p1[0];
            int val1 = p1[1];
            int cnt2 = p2[0];
            int val2 = p2[1];

            if (cnt1 == cnt2) {
                return Integer.compare(firstIdx.get(val1), firstIdx.get(val2));
            }
            return Integer.compare(cnt2, cnt1); // 내림차순
        });

        StringBuilder sb = new StringBuilder();
        for (int[] item : v) {
            int count = item[0];
            int value = item[1];

            for (int i = 0; i < count; i++) {
                sb.append(value).append(' ');
            }
        }

        System.out.println(sb.toString().trim());
    }
}
