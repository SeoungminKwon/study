package backjun.gold;

import java.util.Arrays;
import java.util.Scanner;

public class B2294 {
    static int n, m;
    static int[] dp;
    static int[] coin;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dp = new int[10010];
        coin = new int[1010];

        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            dp[coin[i]] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if((i - coin[j]) < 0) continue;
                if(dp[i - coin[j]] == Integer.MAX_VALUE)continue;
                dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
            }
        }

        if(dp[m] == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(dp[m]);
        }

    }
}
