package codingtest.bfs_dfs.silver;

import java.util.*;
import java.io.*;

public class B2178 {
    static int n, m;
    static int[][] arr = new int[103][103];
    static int[][] visited = new int[103][103];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] split = input.split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        for (int i = 0; i < n; i++) {
            String number = br.readLine();

            for (int j = 0; j < m; j++) {
                arr[i][j] = number.charAt(j) - '0';
            }
        }

        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> v = new ArrayList<>();
        v.add(0);
        v.add(0);
        q.add(v);
        visited[0][0] = 1;

        while (!q.isEmpty()) {
            List<Integer> list = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = list.get(0) + dy[i];
                int nx = list.get(1) + dx[i];

                if(ny < 0 || ny > n - 1 || nx < 0 || nx > m - 1)continue;
                if(visited[ny][nx] != 0) continue;
                if(arr[ny][nx] == 0)continue;
                visited[ny][nx] = visited[list.get(0)][list.get(1)] + 1;
                List<Integer> vector = new ArrayList<>();
                vector.add(ny);
                vector.add(nx);
                q.add(vector);
            }
        }

        System.out.println(visited[n - 1][m - 1]);
    }


}
