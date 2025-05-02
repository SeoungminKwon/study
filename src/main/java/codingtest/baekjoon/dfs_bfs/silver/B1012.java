package codingtest.baekjoon.dfs_bfs.silver;

import java.io.*;
import java.util.*;

public class B1012 {
    static int t;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String args[]) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        t = Integer.parseInt(br.readLine());
//
//        for (int tc = 0; tc < t; tc++) {
//            int n, m, k;
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            n = Integer.parseInt(st.nextToken());
//            m = Integer.parseInt(st.nextToken());
//            k = Integer.parseInt(st.nextToken());
//
//            int[][] arr = new int[n][m];
//            int[][] visited = new int[n][m];
//            for (int i = 0; i < k; i++) {
//                st = new StringTokenizer(br.readLine());
//                int y = Integer.parseInt(st.nextToken());
//                int x = Integer.parseInt(st.nextToken());
//                arr[y][x] = 1;
//            }
//
//            int ret = 0;
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    if(arr[i][j] != 1) continue;
//                    if(visited[i][j] != 0) continue;
//                    ret++;
//                    dfs(i, j, visited, arr, n, m);
//                }
//            }
//
//            System.out.println(ret);
//        }
    }

    static void dfs(int y, int x, int[][] visited, int[][] arr, int n, int m) {
        visited[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(arr[ny][nx] != 1) continue;
            if(visited[ny][nx] != 0) continue;

            dfs(ny, nx, visited, arr, n, m);
        }
    }
}
