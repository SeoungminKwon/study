package codingtest.bfs_dfs.silver;

import java.util.*;
import java.io.*;

public class B2468 {
    static int n;
    static int[][] arr = new int[103][103];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[][] visited = new int[103][103];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                max = Math.max(max, num);
                min = Math.min(min, num);
                arr[i][j] = num;
            }
        }

//        System.out.println("max ; " + max);
//        System.out.println("min ; " + min);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

        int ret = Integer.MIN_VALUE;

        for (int dept = 0; dept <= 100; dept++) {
            visited = new int[103][103];
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j] <= dept) continue;
                    if(visited[i][j] != 0) continue;
                    dfs(i, j, dept);
                    cnt++;
                }
            }

            ret = Math.max(ret, cnt);
        }

        System.out.println(ret);
    }

    static void dfs(int y, int x, int dept) {
//        System.out.println("y : " + y + " x : " + x + " dept : " + dept);
        visited[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
            if(arr[ny][nx] <= dept) continue;
            if(visited[ny][nx] != 0) continue;
            dfs(ny, nx, dept);
        }
    }
}
