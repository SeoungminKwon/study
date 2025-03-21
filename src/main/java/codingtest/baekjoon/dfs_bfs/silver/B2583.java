package codingtest.baekjoon.dfs_bfs.silver;

import java.io.*;
import java.util.*;


public class B2583 {

    static int n, m, k;
    static int[][] arr = new int[103][103];
    static int[][] visited = new int[103][103];

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());


            for (int j = y1; j < y2; j++) {
                for (int l = x1; l < x2; l++) {
                    arr[j][l] = 1;
                }
            }
        }

        int ret = 0;
        List<Integer> retList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] != 0) continue;
                if(visited[i][j] != 0 ) continue;
                ret++;
                int dfsCount = dfs(i, j);
                retList.add(dfsCount);
            }
        }

        Collections.sort(retList);
        System.out.println(ret);
        for (int i = 0; i < retList.size(); i++) {
            if (i == retList.size() - 1) {
                System.out.println(retList.get(i));
            }else{
                System.out.print(retList.get(i) + " ");
            }
        }
    }

    static int dfs(int y, int x) {
        visited[y][x] = 1;
        int count = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(arr[ny][nx] != 0) continue;
            if(visited[ny][nx] != 0) continue;
            count += dfs(ny, nx);
        }

        return count;
    }
}
