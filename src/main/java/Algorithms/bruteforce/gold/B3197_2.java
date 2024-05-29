package Algorithms.bruteforce.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3197_2 {
    static int n, m;
    static int[][] arr = new int[1503][1503];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        int idx = 0;
        Pair[] swanArr = new Pair[2];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'L') swanArr[idx++] = new Pair(i, j);
            }
        }




        int day = 0;
        while (true) {
            check(swanArr[0].y, swanArr[0].x);
            if(Ret.result) break;
            int[][] visited = new int[1503][1503];
            Queue<Pair> q = new LinkedList<>();
            for (Pair p : swanArr) {
                q.add(new Pair(p.y, p.x));
                visited[p.y][p.x] = 1;
            }

            while (!q.isEmpty()) {
                Pair p = q.poll();
                int y = p.y;
                int x = p.x;
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                    if(visited[ny][nx] != 0) continue;
                    if (arr[ny][nx] == 'X') {
                        arr[ny][nx] = '.';
                        visited[ny][nx] = 1;
                        continue;
                    }

                    q.add(new Pair(ny, nx));
                    visited[ny][nx] = visited[y][x] +1;
                }
            }
            day++;
        }
        System.out.println(day);
    }

    static void check(int y, int x) {
        int[][] visited = new int[1503][1503];
        dfs(y, x, visited);
    }

    static void dfs(int y, int x, int[][] visited) {
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m)continue;
            if(arr[ny][nx] == 'X')continue;
            if(visited[ny][nx] != 0)continue;
            if (arr[ny][nx] == 'L') {
                Ret.result = true;
                break;
            }
            dfs(ny, nx, visited);
        }
    }

    static class Ret{
        static boolean result = false;
    }

    static class Pair{
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
