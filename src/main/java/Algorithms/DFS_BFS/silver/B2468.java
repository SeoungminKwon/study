package Algorithms.DFS_BFS.silver;

import java.util.Scanner;

public class B2468 {
    static int[][] arr = new int[103][103];
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int _min = Integer.MAX_VALUE;
        int _max = Integer.MIN_VALUE;
        int ret = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                _max = Math.max(_max, arr[i][j]);
                _min = Math.min(_min, arr[i][j]);
            }
        }

        _min--;_max++;
        for (int t = _min; t <= _max; t++) {
            int cnt = 0;
            visited = new int[103][103];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] > t && visited[i][j] == 0) {
                        cnt++;
                        dfs(i, j, t);
                    }
                }
            }

            ret = Math.max(ret, cnt);
        }
        System.out.println(ret);
    }

    private static void dfs(int y, int x, int t) {

        visited[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n)continue;
            if(visited[ny][nx] != 0)continue;
            if(arr[ny][nx] <= t)continue;
            dfs(ny, nx, t);
        }
    }
}
