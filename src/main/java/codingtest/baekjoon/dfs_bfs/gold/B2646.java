package codingtest.baekjoon.dfs_bfs.gold;

import java.util.*;
import java.io.*;

public class B2646 {
    static int n, m;

    static int[][] arr = new int[103][103];
    static int[][] prev = new int[103][103];
    static int[][] visited = new int[103][103];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        int time = 0;
        while (changeCheese()) {
            time++;
            dfs(0, 0);
        }

        System.out.println(time);

        int cheeseCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(prev[i][j] == 1) cheeseCnt++;
            }
        }
        System.out.println(cheeseCnt);


    }

    static void dfs(int y, int x) {
        visited[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n | nx >= m ) continue;
            if(visited[ny][nx] != 0) continue;
            if (arr[ny][nx] == 1) {
                visited[ny][nx] = 1;
            }else{
                dfs(ny, nx);
            }
        }
    }

    static boolean changeCheese() {
        int cheeseCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prev[i][j] = arr[i][j];
                if (arr[i][j] == 1 && visited[i][j] == 1) {
                    arr[i][j] = 0;
                }
                if(arr[i][j] == 1) cheeseCnt++;
                visited[i][j] = 0;
            }
        }

        if (cheeseCnt >= 1) {
            return true;
        }else{
            return false;
        }
    }
}
