package codingtest.bfs_dfs.silver;

import java.util.*;
import java.io.*;

public class B3474 {
    static int n;
    public static void main(String[] arsg) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            int num2 = 0;
            int num5 = 0;

            for (int j = 2; j <= input; j *= 2) {
                num2 += input / j;
            }

            for (int j = 5; j <= input; j *= 5) {
                num5 += input / j;
            }


            System.out.println(Math.min(num2, num5));
        }
    }
}
