package Algorithms.dp.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2240 {
    static int n, m;
    static int[] b = new int[1004];
    static int[][][] dp = new int[1004][2][34];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(br.readLine());
        }

        // 초기화
        for (int[][] arr : dp) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }

        System.out.println(Math.max(go(0, 0, m),
                go(0, 1, m - 1)));


    }

    static int go(int idx, int tree, int cnt) {

        // 기저사례
        if (cnt < 0) {
            return Integer.MIN_VALUE;
        }

        if (idx == n) {
            return (cnt == 0 ? 0 : Integer.MIN_VALUE);
        }

        //메모리제이션
        if (dp[idx][tree][cnt] != -1) {
            return dp[idx][tree][cnt];
        }

        //로직
        return dp[idx][tree][cnt] = Math.max(
                go(idx + 1, tree, cnt),
                go(idx + 1, tree ^ 1, cnt - 1)
        ) + (tree == b[idx] -1 ? 1 : 0);
    }
}
