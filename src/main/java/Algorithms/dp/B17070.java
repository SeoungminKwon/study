package Algorithms.dp;

import java.util.Scanner;

public class B17070 {
    static int n;
    static int[][] arr = new int[20][20];
    static int[][][] dp = new int[20][20][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp[1][2][0] = 1;



        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == 1 && j == 1)continue;
                if(i == 1 && j == 2)continue;
                for (int k = 0; k < 3; k++) {
                    if (k == 0 && check0(i, j)) {
                        dp[i][j][0] = dp[i][j - 1][1] + dp[i][j - 1][0];
                    } else if (k == 1 && check1(i, j)) {
                        dp[i][j][1] = dp[i-1][j - 1][0] + dp[i-1][j-1][1] + + dp[i - 1][j-1][2];
                    } else if (k == 2 && check2(i, j)) {
                        dp[i][j][2] = dp[i - 1][j][1] + dp[i - 1][j][2];
                    }
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += dp[n][n][i];
        }
        System.out.println(sum);

    }

    static boolean check0(int y, int x) {
        if(arr[y][x] == 1) return false;
        if(x - 1 < 0 && arr[y][x-1] == 1)return false;
        return true;
    }

    static boolean check1(int y, int x) {
        if(arr[y][x] == 1) return false;
        if(y - 1 < 0 || x - 1 < 0 || arr[y-1][x-1] == 1 || arr[y-1][x] == 1 || arr[y][x-1] == 1)return false;
        return true;
    }

    static boolean check2(int y, int x) {
        if(arr[y][x] == 1) return false;
        if(y - 1 < 0 || arr[y-1][x] == 1)return false;
        return true;
    }
}
