package backjun.gold;

import java.util.Arrays;
import java.util.Scanner;

public class B2240 {
    static int[][][] dp;
    static int[] b;
    static int n, m;

    static int go(int idx, int tree, int cnt) {
        if (cnt < 0) return Integer.MIN_VALUE;
        if (idx == n) return 0;
        if (dp[idx][tree][cnt] != -1) return dp[idx][tree][cnt];
        return dp[idx][tree][cnt] = Math.max(go(idx + 1, tree ^ 1, cnt - 1), go(idx + 1, tree, cnt))
                + ((tree == b[idx] - 1) ? 1 : 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        dp = new int[1004][2][34];
        b = new int[1004];

        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        for (int[][] arr2D : dp) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }

        System.out.println(Math.max(go(0, 1, m - 1), go(0, 0, m)));
    }
}

