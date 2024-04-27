package Algorithms.DFS_BFS.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class B2636 {
    static int[][] arr = new int[103][103];
    static int[][] visited;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nm = br.readLine();
        StringTokenizer st = new StringTokenizer(nm, " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ArrayList<Pair> cheese = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (arr[i][j] == 1) {
                    cheese.add(new Pair(i, j));
                }
            }
        }
        int prev = cnt();
        int time = 1;
        while (true) {
            visited = new int[103][103];
            dfs(0, 0);

            ArrayList<Pair> removeCheese = new ArrayList<>();
            for (Pair pair : cheese) {
                if (visited[pair.y][pair.x] == 1) {
                    arr[pair.y][pair.x] = 0;
                    removeCheese.add(new Pair(pair.y, pair.x));
                }
            }
            for (Pair pair : removeCheese) {
                arr[pair.y][pair.x] = 0;
                cheese.remove(pair);
            }
            if (cheese.isEmpty()) {
                break;
            }
            prev = cnt();
            time++;
        }

        System.out.println(time);
        System.out.println(prev);

    }

    static class Pair{
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair pair = (Pair) o;
            return y == pair.y && x == pair.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }

    static void dfs(int y, int x) {
        visited[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m)continue;
            if(visited[ny][nx] != 0)continue;
            if(arr[ny][nx] == 1){
                visited[ny][nx] = 1;
                continue;
            }
            dfs(ny, nx);
        }
    }

    static int cnt() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 1)cnt++;
            }
        }
        return cnt;
    }
}
