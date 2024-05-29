package Algorithms.bruteforce.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B14497 {
    static int n,m;
    static char[][] arr = new char[303][303];
    static int[][] visited = new int[303][303];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static ArrayList<Pair> dieList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int y1 = Integer.parseInt(st.nextToken()); y1--;
        int x1 = Integer.parseInt(st.nextToken()); x1--;
        int y2 = Integer.parseInt(st.nextToken()); y2--;
        int x2 = Integer.parseInt(st.nextToken()); x2--;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int ret = 0;
        while (check(x2, y2)) {
            ret ++;
            visited = new int[303][303];
            bfs(y1, x1);
            goDie();
        }
        System.out.println(ret);
    }

    static void bfs(int y, int x) {
        visited[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m)continue;
            if(visited[ny][nx] != 0)continue;
            if(arr[ny][nx] == '1' || arr[ny][nx] == '#'){
                visited[ny][nx] = 1;
                dieList.add(new Pair(ny, nx));
                continue;
            }
            bfs(ny, nx);
        }
    }

    static void goDie() {
        for (Pair pair : dieList) {
            arr[pair.y][pair.x] = '0';
        }
        dieList.clear();
    }

    static boolean check(int x2, int y2) {
        if(arr[y2][x2] != '#') return false;
        return true;
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
