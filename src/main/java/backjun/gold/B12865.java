package backjun.gold;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class B12865 {
    static int n, k;
    static int w, v;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        dp = new int[100004];

        for (int i = 0; i < n; i++) {
            w = sc.nextInt();
            v = sc.nextInt();

            for (int j = k; j >= w; j--) {
                dp[j] = Math.max(dp[j],dp[j - w] + v);
            }
        }

        System.out.println(dp[k]);
    }
}
