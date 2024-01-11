package backjun.gold;

import java.util.Arrays;
import java.util.Scanner;

public class B2240_2 {
    static int[][][] dp;
    static int[] plum;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dp = new int[1004][2][34];
        plum = new int[1004];

        for (int i = 0; i < n; i++) {
            plum[i] = sc.nextInt();
        }

        for (int[][] dp_2 : dp) {
            for (int[] dp_3 : dp_2) {
                Arrays.fill(dp_3, -1);
            }
        }

        int ret = Math.max(go(0, 1, m - 1), go(0, 0, m));
        System.out.println(ret);
    }


    static int go(int time, int tree, int cnt) {
        if (cnt < 0) {
            return Integer.MIN_VALUE;
        }
        if (time == n) {
            return 0;
        }
        if(dp[time][tree][cnt] != -1) return dp[time][tree][cnt];
        return dp[time][tree][cnt] = Math.max(go(time + 1, tree^1, cnt - 1), go(time + 1, tree, cnt))
                + ((tree == plum[tree] - 1) ? 1 : 0);
    }
}
