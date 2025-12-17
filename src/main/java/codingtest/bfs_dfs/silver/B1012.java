package codingtest.bfs_dfs.silver;

import java.util.*;
import java.io.*;

public class B1012 {
    static int tc;
    static int[][] arr = new int[53][53];
    static int[][] visited = new int[53][53];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, m, k;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        tc = Integer.parseInt(st.nextToken());

        for (int t = 0; t < tc; t++) {
            n = 0; m = 0; k = 0;

            arr = new int[53][53];
            visited = new int[53][53];

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }


            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1 && visited[i][j] == 0) {
                        dfs(i, j, n, m);
                        cnt++;
//                        System.out.print("cnt : " + cnt);
                    }
                }
            }

//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.print(visited[i][j]);
//                }
//                System.out.println();
//            }

            System.out.println(cnt);


        }
    }

    static void dfs(int y, int x, int n, int m) {
        visited[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny > n || nx < 0 || nx > m) continue;
            if(visited[ny][nx] != 0) continue;
            if(arr[ny][nx] != 1) continue;
            dfs(ny, nx, n, m);
        }

    }
}
