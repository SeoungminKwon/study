package Algorithms.dp.re;

import java.util.Arrays;
import java.util.Scanner;

public class B4811 {

    static long[][] dp = new long[31][31];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if(n == 0) break;

            // 초기화
            for (int i = 0; i <= 30; i++) {
                Arrays.fill(dp[i], 0);
            }

            System.out.println(go(n, 0));
        }
    }

    static long go(int whole, int notWhole) {
        // 기저 사례
        if(whole == 0 && notWhole == 0)return 1;

        //메모리제이션
        if(dp[whole][notWhole] != 0)return dp[whole][notWhole];

        //로직
        long ret = 0;

        if (notWhole > 0) {
            ret += go(whole, notWhole - 1);
        }

        if (whole > 0) {
            ret += go(whole -1, notWhole + 1);
        }

        dp[whole][notWhole] += ret;
        return ret;
    }
}
