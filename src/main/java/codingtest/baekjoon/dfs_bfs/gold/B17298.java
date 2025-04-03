package codingtest.baekjoon.dfs_bfs.gold;

import java.io.*;
import java.util.*;

public class B17298 {
    static int n;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] ret = new int[n];
        Arrays.fill(ret, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                ret[stack.pop()] = a[i];
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : ret) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
