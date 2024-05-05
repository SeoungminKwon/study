package Algorithms.bruteforce.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4179 {
    static char[][] arr = new char[1003][1003];
    static int[][] visitedJ = new int[1003][1003];
    static int[][] visitedF = new int[1003][1003];
    static ArrayList<Pair> fireList = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, m;
    static int ret = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Pair jihun = new Pair(0, 0);

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'F') {
                    fireList.add(new Pair(i, j));
                } else if (arr[i][j] == 'J') {
                    jihun = new Pair(i, j);
                }
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(jihun);
        visitedJ[jihun.y][jihun.x] = 1;
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int y = p.y;
            int x = p.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m)continue;
                if(arr[ny][nx] == '#')continue;
                if(visitedJ[ny][nx] != 0)continue;
                queue.add(new Pair(ny, nx));
                visitedJ[ny][nx] = visitedJ[y][x] + 1;
            }
        }

        queue = new LinkedList<>();
        for (Pair fire : fireList) {
            queue.add(fire);
            visitedF[fire.y][fire.x] = 1;
        }

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int y = p.y;
            int x = p.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0|| ny >= n || nx >= m)continue;
                if(visitedF[ny][nx] != 0)continue;
                if(arr[ny][nx] == '#')continue;
                queue.add(new Pair(ny, nx));
                visitedF[ny][nx] = visitedF[y][x] + 1;
            }
        }

        check();
        if (ret == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(ret);
        }

    }

    static void check() {
        for (int i = 0; i < n; i++) {
            if(arr[i][0]  == '#')continue;
            if(visitedJ[i][0] == 0)continue;
            if (visitedF[i][0] == 0) {
                ret = Math.min(ret, visitedJ[i][0]);
            }
            if(visitedJ[i][0] < visitedF[i][0]) ret = Math.min(ret, visitedJ[i][0]);
        }

        for (int i = 0; i < n; i++) {
            if(arr[i][m-1] == '#')continue;
            if(visitedJ[i][m-1] == 0)continue;
            if (visitedF[i][m-1] == 0) {
                ret = Math.min(ret, visitedJ[i][m-1]);
            }
            if(visitedJ[i][m-1] < visitedF[i][m-1]) ret = Math.min(ret, visitedJ[i][m-1]);
        }

        for (int i = 0; i < m; i++) {
            if(arr[0][i] == '#')continue;
            if(visitedJ[0][i] == 0)continue;
            if (visitedF[0][i] == 0) {
                ret = Math.min(ret, visitedJ[0][i]);
            }
            if(visitedJ[0][i] < visitedF[0][i])ret = Math.min(ret, visitedJ[0][i]);
        }

        for (int i = 0; i < m; i++) {
            if(arr[n-1][i] == '#')continue;
            if(visitedJ[n-1][i] == 0)continue;
            if (visitedF[n-1][i] == 0) {
                ret = Math.min(ret, visitedJ[n-1][i]);
            }
            if(visitedJ[n-1][i] < visitedF[n-1][i])ret = Math.min(ret, visitedJ[n-1][i]);
        }
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
