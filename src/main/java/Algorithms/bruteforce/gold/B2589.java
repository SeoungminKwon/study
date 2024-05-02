package Algorithms.bruteforce.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2589 {
    static char[][] arr = new char[53][53];
    static List<Pair> landList = new ArrayList<>();
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(c == 'L')landList.add(new Pair(i, j));
                arr[i][j] = c;
            }
        }

        for (Pair pair : landList) {
            visited = new int[53][53];
            Queue<Pair> q = new LinkedList<>();
            q.add(pair);
            visited[pair.y][pair.x] = 1;
            int ret = Integer.MIN_VALUE;
            while (!q.isEmpty()) {
                Pair p = q.poll();
                int y = p.y;
                int x = p.x;

                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= m)continue;
                    if(visited[ny][nx] != 0)continue;
                    if(arr[ny][nx] == 'W')continue;
                    q.add(new Pair(ny, nx));
                    visited[ny][nx] = visited[y][x] + 1;
                    ret = Math.max(ret, visited[ny][nx]);
                }
            }


            result = Math.max(ret, result);
        }
        System.out.println(result -1);

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
