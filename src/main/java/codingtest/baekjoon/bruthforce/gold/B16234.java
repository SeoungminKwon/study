package codingtest.baekjoon.bruthforce.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B16234 {
    static int n, l, r;
    static int[][] arr = new int[53][53];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int cnt = 0;
        while (true) {
            List<List<Pair>> unions = new ArrayList<>();
            int[][] visited = new int[53][53];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visited[i][j] != 0) continue;
                    List<Pair> union = new ArrayList<>();
                    union.add(new Pair(i, j));
                    dfs(i, j, union, visited);

                    if(union.size() != 1) unions.add(union);
                }
            }

            if (unions.isEmpty()) {
                System.out.println(cnt);
                break;
            }else{
                for (List<Pair> union : unions) {
                    move(union);
                }
                cnt++;
            }
        }
    }

    static void move(List<Pair> union) {
        int size = union.size();
        int total = 0;

        for (Pair pair : union) {
            total += arr[pair.y][pair.x];
        }

        int avg = total / size;
        for (Pair pair : union) {
            arr[pair.y][pair.x] = avg;
        }
    }

    static void dfs(int y, int x, List<Pair> union, int[][] visited) {
        visited[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if(visited[ny][nx] != 0) continue;

            int abs = Math.abs(arr[y][x] - arr[ny][nx]);
            if (abs >= l && abs <= r) {
                union.add(new Pair(ny, nx));
                dfs(ny, nx, union, visited);
            }
        }
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
