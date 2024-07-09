package Algorithms.dp.re;

import java.util.Arrays;
import java.util.Scanner;

public class B2240 {
    static int n, m;
    static int[] b = new int[1004];
    static int[][][] dp = new int[1004][2][34];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        for (int[][] arr : dp) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }

        System.out.println(Math.max(go(0, 0, m),
                go(0, 1, m - 1)));


    }

    static int go(int idx, int tree, int cnt) {
        if (cnt < 0) {
            return Integer.MIN_VALUE;
        }
        if (idx == n) {
            return (cnt == 0 ? 0 : Integer.MIN_VALUE);
        }

        if (dp[idx][tree][cnt] != -1) {
            return dp[idx][tree][cnt];
        }

        return dp[idx][tree][cnt] = Math.max(
                go(idx + 1, tree, cnt),
                go(idx + 1, tree ^ 1, cnt -1 )
        )
                +(tree == b[idx] - 1 ? 1 : 0);
    }
}
