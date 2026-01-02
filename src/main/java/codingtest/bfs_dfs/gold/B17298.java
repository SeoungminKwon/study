package codingtest.bfs_dfs.gold;

import java.util.*;
import java.io.*;

public class B17298 {
    static int n;
    static int[] arr = new int[1_000_004];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] a = new int[1_000_004];
        int[] ret = new int[1_000_004];
        Arrays.fill(ret, -1);
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                ret[stack.pop()] = a[i];
            }
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ret[i]).append(' ');
        }
        System.out.println(sb.toString().trim());

    }
}
