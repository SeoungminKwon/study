package codingtest.baekjoon.dfs_bfs.silver;

import java.io.*;
import java.util.*;

public class B2178 {
    static int n, m;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] arr = new int[103][103];
    static int[][] visited = new int[103][103];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = temp.charAt(j) - '0';
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        visited[0][0] = 1;

        while (!q.isEmpty()) {
            Pair pair = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = pair.y + dy[i];
                int nx = pair.x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if(arr[ny][nx] != 1) continue;
                if(visited[ny][nx] != 0) continue;

                visited[ny][nx] = visited[pair.y][pair.x] + 1;
                q.add(new Pair(ny, nx));
            }
        }

        System.out.println(visited[n-1][m-1]);


    }

    static class Pair{
        int y;
        int x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
