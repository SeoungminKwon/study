package Algorithms.bitmasking.gold;

import java.util.Scanner;

public class B14391 {
    static int n, m;
    static int[][] arr = new int[6][6];
    static int[][] visited = new int[6][6];
    static int ret = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }


    }

    static void dfs(int y, int sum) {
        if (y == m) {
            for (int i = 0; i < m; i++) {
                int tmp = 1;
                int s = 0;

                for (int j = n-1; j > 0; j--) {
                    if(visited[j][i] != 0){
                        tmp = 1;
                        continue;
                    }
                    s += arr[j][i] * tmp;
                    tmp *= 10;
                }
                sum += s;
            }
            ret = Math.max(ret, sum);
            return;
        }

        for (int i = 1; i < (1 << m); i++) {

        }
    }

    static int solve(int y, int num) {
        int tmp = 1;
        int sum = 0;

        for (int i = 0; i < m; i++) {
            if((num & (1 << m)) != 0) {
                sum += arr[y][i] * tmp;
                tmp *= 10;
            }else tmp = 1;
        }
        return sum;
    }
}
