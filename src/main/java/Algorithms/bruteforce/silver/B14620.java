package Algorithms.bruteforce.silver;

import java.util.Scanner;

public class B14620 {
    static int n;
    static int[][] arr = new int[13][13];
    static int[][] visited = new int[13][13];
    static int ret = Integer.MAX_VALUE;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        flower(0, 0);
        System.out.println(ret);
    }

    static boolean check(int y, int x) {
        if(visited[y][x] != 0) return false;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                return false;
            }
        }
        return true;
    }

    static int setFlower(int y, int x) {
        visited[y][x] = 1;
        int s = arr[y][x];
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            visited[ny][nx] = 1;
            s += arr[ny][nx];
        }
        return s;
    }

    static void eraseFlower(int y, int x) {
        visited[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int ny = dy[i];
            int nx = dx[i];
            visited[ny][nx] = 0;
        }
    }

    static void flower(int cnt, int hap) {
        if (cnt == 3) {
            ret = Math.min(ret, hap);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check(i, j)) {
                    flower(cnt + 1, hap + setFlower(i, j));
                    eraseFlower(i, j);
                }
            }
        }
    }
}
