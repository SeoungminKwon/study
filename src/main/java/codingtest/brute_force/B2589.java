package codingtest.brute_force;

import java.io.*;
import java.util.*;

public class B2589 {

    static int n, m;
    static char[][] arr = new char[53][53];
    static int[][] visited = new int[53][53];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ret = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        String buffer = sc.nextLine();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();

            for (int j = 0; j < m; j++) {
                char c = input.charAt(j);
                arr[i][j] = c;
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(arr[i][j] == 'W') continue;
                visited = new int[53][53];
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i, j));
                visited[i][j] = 1;

                while (!q.isEmpty()) {
                    Pair now = q.poll();

                    for (int k = 0; k < 4; k++) {
                        int ny = now.y + dy[k];
                        int nx = now.x + dx[k];

                        if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                        if(visited[ny][nx] != 0) continue;
                        if(arr[ny][nx] != 'L') continue;

                        visited[ny][nx] = visited[now.y][now.x] + 1;
                        q.add(new Pair(ny, nx));
                    }
//                    System.out.println("while 중...");
                }

                ret = Math.max(ret, map());
            }
        }
        System.out.println(ret - 1);
    }

    static int map() {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 'W') continue;
                max = Math.max(max, visited[i][j]);
            }
        }

        return max;
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
