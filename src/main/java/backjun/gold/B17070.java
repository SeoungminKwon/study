package backjun.gold;

import java.util.*;

public class B17070{

    static int n;
    static int[][] a = new int[23][23];
    static int[][][] dp = new int[23][23][3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        dp[1][2][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(check(i, j + 1, 0))dp[i][j + 1][0] += dp[i][j][0];
                if(check(i + 1, j + 1, 1))dp[i + 1][j + 1][1] += dp[i][j][0];

                if(check(i + 1, j, 2))dp[i + 1][j][2] += dp[i][j][2];
                if(check(i + 1, j + 1, 1))dp[i + 1][j + 1][1] += dp[i][j][2];

                if(check(i, j + 1, 0))dp[i][j + 1][0] += dp[i][j][1];
                if(check(i + 1, j, 2))dp[i + 1][j][2] += dp[i][j][1];
                if(check(i + 1, j + 1, 1))dp[i + 1][j + 1][1] += dp[i][j][1];
            }
        }

        int ret = 0;
        for (int i = 0; i < 3; i++) {
            ret += dp[n][n][i];
        }

        System.out.println(ret);


    }

    static boolean check(int y, int x, int dir) {
        if (dir == 0 || dir == 2) {
            if(a[y][x] == 1) return false;
        } else if (dir == 1) {
            if (a[y][x] == 1 || a[y - 1][x] == 1 || a[y][x - 1] == 1) {
                return false;
            }
        }

        return true;
    }

}