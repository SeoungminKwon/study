package backjun.sliver;

import java.sql.Array;
import java.util.Scanner;

public class B2468 {
    static int n;
    static int[][] a;
    static int[][] visited;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();

            }
        }
        int result = -987654321;
        for (int h = 0; h <= 100; h++) {
            int cnt = 0;
            int ret = -987654321;
            visited = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(a[i][j] <= h)continue;
                    if(visited[i][j] != 0)continue;
                    cnt++;
                    dfs(i, j, h);
                }
            }
            ret = Math.max(ret, cnt);
            result = Math.max(ret, result);
        }

        System.out.println(result);
    }

    static void dfs(int y, int x, int h){
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n)continue;
            if(visited[ny][nx] != 0)continue;
            if(a[ny][nx] <= h)continue;
            dfs(ny, nx, h);
        }
    }
}
