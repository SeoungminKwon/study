package codingtest.bfs_dfs.silver;

import java.util.*;
import java.io.*;

public class B3474 {
    static int tc;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tc = sc.nextInt();
        for (int t = 0; t < tc; t++) {
            int n = sc.nextInt();
            int num2 = 0;
            int num5 = 0;

            for (int i = 2; i <= n; i *= 2) {
                num2 += n / i;
            }

            for (int i = 5; i <= n; i *= 5) {
                num5 += n / i;
            }

            System.out.println(Math.min(num2, num5));
        }
    }
}
