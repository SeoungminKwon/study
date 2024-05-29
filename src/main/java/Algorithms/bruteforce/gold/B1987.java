package Algorithms.bruteforce.gold;

import java.util.Scanner;

public class B1987 {
    static int n, m, ret;
    static char[][] arr = new char[23][23];
    static int[] visited = new int[30];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        visited[arr[0][0] - 'A'] = 1;
        go(0, 0, 1);
        System.out.println(ret);
    }

    static void go(int y, int x, int cnt) {
        ret = Math.max(ret, cnt);

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m)continue;
            int next = (int) (arr[ny][nx] - 'A');
            if (visited[next] == 0) {
                visited[next] = 1;
                go(ny, nx, cnt + 1);
                visited[next] = 0;
            }
        }
    }
}
