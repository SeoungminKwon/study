package Algorithms.dp.re;

import java.util.Scanner;

public class B4811 {
    static long[][] dp = new long[31][31];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            //초기화
            for (int i = 0; i <= 30; i++) {
                for (int j = 0; j <= 30; j++) {
                    dp[i][j] = 0;
                }
            }

            System.out.println(go(n, 0));
        }
    }

    static long go(int whole, int notWHole) {
        // 기저사례
        if (whole == 0 && notWHole == 0) {
            return 1;
        }

        //메모리제이션
        if (dp[whole][notWHole] != 0) {
            return dp[whole][notWHole];
        }

        //로직
        long ret = 0;
        if (whole > 0) {
            ret += go(whole - 1, notWHole + 1);
        }

        if (notWHole > 0) {
            ret += go(whole, notWHole - 1);
        }

        dp[whole][notWHole] = ret;
        return ret;

    }
}
