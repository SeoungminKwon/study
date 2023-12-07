package backjun.gold;

import java.util.*;

public class B2234 {

    static int ret1;
    static int ret2;
    static int ret3;

    static int m;
    static int n;

    static int[][] a = new int[53][53];
    static int[][] b = new int[53][53];
    static int[][] visited = new int[53][53];
    static int[][] visited2 = new int[53][53];

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};

    static int[] countingArr = new int[2503];
    static int result = Integer.MIN_VALUE;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        //2500
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j] != 0)continue;
                //방갯수찾기
                cnt++;
                dfs(i, j, cnt);
            }
        }
        ret1 = cnt;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                countingArr[visited[i][j]]++;
            }
        }
        OptionalInt max = Arrays.stream(countingArr).max();
        ret2 = max.getAsInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited2[i][j] != 0)continue;
                dfs2(i, j);
            }
        }

        System.out.println(ret1);
        System.out.println(ret2);
        System.out.println(ret3);
    }

    static void dfs(int y, int x, int cnt) {
        visited[y][x] = cnt;
        for (int i = 0; i < 4; i++) {
            if((a[y][x] & (1 << i)) != 0) continue;
            int ny = y + dy[i];
            int nx = x + dx[i];
            try{
                if(visited[ny][nx] != 0)continue;
            }catch (Exception e){
                System.out.println(ny);
                System.out.println(nx);

            }

            dfs(ny, nx, cnt);
        }
    }

    static void dfs2(int y, int x) {
        visited2[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(visited2[ny][nx] != 0)continue;
            if(ny < 0 || nx < 0 || ny >= n || nx >= m)continue;
            if((a[y][x] & (1 << i)) != 0){
                result = Math.max(result, (visited[y][x] + visited[ny][nx]));
            }

            dfs2(ny, nx);
        }
    }
}
