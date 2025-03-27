package codingtest.baekjoon.dfs_bfs.silver;

import java.util.*;
import java.io.*;

public class B3474 {
    static int t;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int num = Integer.parseInt(br.readLine());
            int num2 = 0;
            int num5 = 0;

            for (int i = 2; i <= num; i *= 2) {
                num2 += num / i;
            }

            for (int i = 5; i <= num; i *= 5) {
                num5 += num / i;
            }

            System.out.println(Math.min(num2, num5));
        }
    }
}
