package codingtest.baekjoon.bruthforce.gold;

import java.util.*;
import java.io.*;

public class B14497 {

    static int n, m;
    static char [][] arr = new char[304][304];
    static Pair junan;
    static Pair thief;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        junan = new Pair(Integer.parseInt(st.nextToken()) -1, Integer.parseInt(st.nextToken()) -1);
        thief = new Pair(Integer.parseInt(st.nextToken()) -1, Integer.parseInt(st.nextToken()) -1);

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = temp.charAt(j);
            }
        }


        int jump = 0;
        while (true) {
            jump++;
            int[][] visited = new int[304][304];
            List<Pair> change = new ArrayList<Pair>();
            dfs(visited, junan, change);
            if (visited[thief.y][thief.x] != 0) {
                break;
            }else{
                for (Pair p : change) {
                    arr[p.y][p.x] = '0';
                }
            }
        }

        System.out.println(jump);
    }

    static void dfs(int[][] visited, Pair now, List<Pair> change) {
        visited[now.y][now.x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = now.y + dy[i];
            int nx = now.x + dx[i];

            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if(visited[ny][nx] != 0) continue;
            if (arr[ny][nx] == '1') {
                change.add(new Pair(ny, nx));
                continue;
            } else if(arr[ny][nx] == '#');

            dfs(visited, new Pair(ny, nx), change);
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
