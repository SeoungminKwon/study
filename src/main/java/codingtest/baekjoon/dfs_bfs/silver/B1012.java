package codingtest.baekjoon.dfs_bfs.silver;


import java.io.*;

public class B1012 {
    static int t;
    static int n, m, l;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] arr = new int[53][53];
    static int[][] visited = new int[53][53];
    static int ret = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {

            arr = new int[53][53];
            visited = new int[53][53];
            String[] inputs = br.readLine().split(" ");
            n = Integer.parseInt(inputs[0]);
            m = Integer.parseInt(inputs[1]);
            l = Integer.parseInt(inputs[2]);
            ret = 0;

            for (int i = 0; i < l; i++) {
                String[] temp = br.readLine().split(" ");
                int y = Integer.parseInt(temp[0]);
                int x = Integer.parseInt(temp[1]);

                arr[y][x] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] == 0) continue;
                    if(visited[i][j] == 1) continue;
                    ret++;
                    bfs(i, j);
                }
            }
            System.out.println(ret);


        }
    }



    static void bfs(int y, int x) {
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(arr[ny][nx] == 0)continue;
            if(visited[ny][nx] == 1) continue;
            bfs(ny, nx);
        }
    }

}
