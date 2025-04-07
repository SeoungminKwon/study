package codingtest.baekjoon.bruthforce.gold;

import java.io.*;
import java.util.*;

public class B2589 {
    static int n, m;
    static char[][] arr = new char[53][53];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ret = Integer.MIN_VALUE;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String inputs = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = inputs.charAt(j);
                arr[i][j] = c;
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 'W') continue;
                int[][] visited = new int[53][53];
                visited[i][j] = 1;

                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i, j));

                while (!q.isEmpty()) {
                    Pair pair = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int ny = pair.y + dy[k];
                        int nx = pair.x + dx[k];
                        if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                        if(visited[ny][nx] != 0) continue;
                        if(arr[ny][nx] == 'W') continue;
                        visited[ny][nx] = visited[pair.y][pair.x] + 1;
                        ret = Math.max(ret, visited[ny][nx]);
                        q.add(new Pair(ny, nx));
                    }
                }
            }
        }

        System.out.println(ret - 1);
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
