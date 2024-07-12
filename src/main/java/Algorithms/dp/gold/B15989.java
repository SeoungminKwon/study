package Algorithms.dp.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15989 {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        int[] dp = new int[10004];
        dp[0] = 1;

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 10000; j++) {
                if (j - i >= 0) {
                    dp[j] += dp[j - i];
                }
            }
        }

        for (int tc = 0; tc < t; tc++) {
            int tmp = Integer.parseInt(br.readLine());
            System.out.println(dp[tmp]);
        }
    }
}
