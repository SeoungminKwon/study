package Algorithms.re.bf;

import java.util.Scanner;

public class B15684 {
    static int n, m, h;
    static boolean[][] visited = new boolean[34][34];
    static int ret = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            visited[a][b] = true;
        }

        go(1, 0);
        System.out.println(ret == Integer.MAX_VALUE ? -1 : ret);
    }

    static boolean check() {
        for (int i = 1; i <= n; i++) {
            int start = i;
            for (int j = 1; j <= h; j++) {
                if(visited[j][start]) start++;
                else if(visited[j][start-1])start--;
            }
            if(start != i) return false;
        }
        return true;
    }

    static void go(int here, int cnt) {
        if(cnt > 3 || cnt >= ret) return;
        if (check()) {
            ret = Math.min(ret, cnt);
            return;
        }

        for (int i = here; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                if(visited[i][j] || visited[i][j -1] || visited[i][j + 1])continue;
                visited[i][j] = true;
                go(i, cnt + 1);
                visited[i][j] = false;
            }
        }
    }
}
