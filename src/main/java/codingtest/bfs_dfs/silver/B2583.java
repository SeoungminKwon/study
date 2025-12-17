package codingtest.bfs_dfs.silver;

import java.util.*;
import java.io.*;

public class B2583 {
    static int m, n, k;
    static int[][] arr = new int[104][104];
    static int[][] visited = new int[104][104];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        int cnt = 0;
        List<Integer> retList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1) continue;
                if(visited[i][j] == 1) continue;
                cnt++;
                List<Pair> pairList = new ArrayList<>();
                bfs(i, j, pairList);
                retList.add(pairList.size());
            }
        }
        System.out.println(cnt);
        Collections.sort(retList);
        for (int ret : retList) {
            System.out.print(ret + " ");
        }

    }

    static void bfs(int y, int x, List<Pair> list) {
        visited[y][x] = 1;
        list.add(new Pair(y, x));

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= m || nx < 0 || nx >= n) continue;
            if(visited[ny][nx] != 0) continue;
            if(arr[ny][nx] == 1) continue;
            bfs(ny, nx, list);
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
