package backjun.gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2098 {

    static int n;
    static int[][] w, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = new int[20][20];
        dp = new int[20][1 << n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(tsp(0, 1));

    }

    static int tsp(int now, int visited) {
        if (visited == (1 << n) - 1) {
            if(w[now][0] == 0) return Integer.MAX_VALUE;
            return w[now][0];
        }

        if(dp[now][visited] != -1) return dp[now][visited];
        dp[now][visited] = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) == 0 && w[now][i] != 0) {
                dp[now][visited] = Math.min(dp[now][visited], tsp(i, visited | (1 << i) + w[now][i]));
            }
        }
        return dp[now][visited];
    }
}
