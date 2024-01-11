package backjun.gold;

import java.util.Arrays;
import java.util.Scanner;

public class B2293 {
    static int[] coin;
    static int[] dp;
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        coin = new int[104];
        dp = new int[10004];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= m; j++) {
                dp[j] += dp[j - coin[i]];
            }
        }

        System.out.println(dp[m]);
    }
}
