package codingtest.baekjoon.dfs_bfs.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2178 {

    static int n, m;
    static int[][] arr = new int[103][103];
    static int[][] visited = new int[103][103];
    static Queue<Pair> q = new LinkedList<>();

    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        String buffer = sc.nextLine();

        for (int i = 0; i < n; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < m; j++) {
                int number = temp.charAt(j) - '0';
                arr[i][j] = number;
            }
        }

        q.add(new Pair(0, 0));
        visited[0][0] = 1;

        while (!q.isEmpty()) {

            Pair now = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if(ny < 0 || nx < 0 || ny > n || nx > m) continue;
                if(arr[ny][nx] != 1) continue;
                if(visited[ny][nx] != 0) continue;

                visited[ny][nx] = visited[now.y][now.x] + 1;
                q.add(new Pair(ny, nx));

            }
        }

        System.out.println(visited[n - 1][m - 1]);

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
