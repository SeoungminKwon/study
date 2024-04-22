package Algorithms.DFS_BFS.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B2583 {
    static int n, m, k;
    static int[][] arr;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        arr = new int[103][103];
        visited = new int[103][103];

        for (int t = 0; t < k; t++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        ArrayList<Integer> ret = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 && visited[i][j] == 0) {
                    cnt++;
                    int dfs = dfs(i, j, 0);
                    ret.add(dfs);
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(ret);
        for (Integer i : ret) {
            System.out.print(i + " ");
        }


    }

    private static int dfs(int y, int x, int total) {
        visited[y][x] = 1;
        total++;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m)continue;
            if(visited[ny][nx] != 0)continue;
            if(arr[ny][nx] == 1)continue;
            total = dfs(ny, nx, total);
        }
        return total;
    }
}
