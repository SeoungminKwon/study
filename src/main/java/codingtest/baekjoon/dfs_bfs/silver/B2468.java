package codingtest.baekjoon.dfs_bfs.silver;

import java.io.*;

public class B2468 {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n;
    static int[][] arr = new int[103][103];
    static int[][] visited = new int[103][103];

    static int ret = 0;
    static int result = Integer.MIN_VALUE;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int tempInt = Integer.parseInt(temp[j]);
                arr[i][j] = tempInt;
                max = Math.max(max, tempInt);
                min = Math.min(min, tempInt);
            }
        }

        for (int deepth = 0; deepth <= max; deepth++) {
            ret = 0;
            visited = new int[103][103];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j] <= deepth) continue;
                    if(visited[i][j] != 0) continue;
                    ret++;
                    dfs(i, j, deepth);
                }
            }

            result = Math.max(result, ret);
        }

        System.out.println(result);
    }

    static void dfs(int y, int x, int deepth) {
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if(arr[ny][nx] <= deepth) continue;
            if(visited[ny][nx] != 0) continue;
            dfs(ny, nx, deepth);
        }
    }
}
