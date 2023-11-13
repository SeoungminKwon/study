package backjun.sliver;

import java.util.Arrays;
import java.util.Scanner;

public class B1012 {
    static int n, m, k;
    static int[][] a = new int[54][54];
    static int[][] visited = new int[54][54];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int tc = 0; tc < t; tc++){
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();
            a = new int[53][53];
            visited = new int[53][53];
            for(int i = 0; i < k; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                a[y][x] = 1;
            }


            int cnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(a[i][j] != 1)continue;
                    if(visited[i][j] != 0)continue;
                    cnt++;
                    dfs(i, j, cnt);
                }
            }
            System.out.println(cnt);
        }
    }

    static void dfs(int y, int x, int cnt){
        visited[y][x] = cnt;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m)continue;
            if(a[ny][nx] == 0)continue;
            if(visited[ny][nx] != 0)continue;
            dfs(ny, nx, cnt);
        }
    }
}
