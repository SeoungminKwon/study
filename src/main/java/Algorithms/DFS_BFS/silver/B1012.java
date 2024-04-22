package Algorithms.DFS_BFS.silver;

import java.util.Scanner;

public class B1012 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] arr, visited;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            arr = new int[53][53];
            visited = new int[53][53];
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();
            int cnt = 0;

            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[y][x] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1 && visited[i][j] == 0) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(cnt);
        }

    }

    static void dfs(int y, int x) {

        visited[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m)continue;
            if(visited[ny][nx] != 0)continue;
            if(arr[ny][nx] == 0)continue;
            dfs(ny, nx);
        }
    }
}
