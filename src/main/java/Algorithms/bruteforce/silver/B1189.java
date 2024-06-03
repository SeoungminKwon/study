package Algorithms.bruteforce.silver;

import java.util.Scanner;

public class B1189 {
    static int n, m, k;
    static char[][] arr = new char[10][10];
    static int[][] visited = new int[10][10];

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ret = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        visited[n-1][0] = 1;
        dfs(n - 1, 0);
        System.out.println(ret);
    }

    static void dfs(int y, int x) {

        if (y == 0 && x == m - 1) {
            if (visited[y][x] == k) {
                ret++;
                return;
            }
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m)continue;
            if(visited[ny][nx] != 0)continue;
            if(arr[ny][nx] == 'T')continue;
            visited[ny][nx] = visited[y][x] + 1;
            dfs(ny, nx);
            visited[ny][nx] = 0;
        }
    }
}
