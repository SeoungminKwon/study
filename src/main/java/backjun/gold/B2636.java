package backjun.gold;

import java.util.Arrays;
import java.util.Scanner;

public class B2636 {
    static int[][] a = new int[103][103];
    static int[][] visited;
    static int n;
    static int m;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0 ; i< n; i++){
            for(int j = 0; j < m; j++){
                a[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++){
            a[i][0] = -1;
            a[i][m-1] = -1;
        }
        for(int j = 0; j < m; j++){
            a[0][j] = -1;
            a[n-1][j] = -1;
        }


        int[][] copyA = new int[103][103];
        int ret = 0;
        while(check()){

            for(int i = 0 ; i < 103; i++){
                copyA[i] = a[i].clone();
            }


            visited = new int[103][103];
            ret++;
            for(int i = 0; i < n; i++){
                dfs(i, 0);
                dfs(i, m-1);
            }

            for(int j = 0; j < m; j++){
                dfs(0, j);
                dfs(n-1, j);
            }


        }

        System.out.println(ret);
        int cnt = 0;
        for(int i = 0 ; i  <n; i++){
            for(int j = 0 ; j < m; j++){
                if(copyA[i][j] == 1)cnt++;
            }
        }
        System.out.println(cnt);
    }

    static boolean check(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] == 1)return true;
            }
        }
        return false;
    }

    static void dfs(int y, int x){
        visited[y][x] = 1;

        if(a[y][x] == 1){
            a[y][x] = 0;
            return;
        }

        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m)continue;
            if(visited[ny][nx] != 0)continue;
            dfs(ny, nx);
        }
    }
}
