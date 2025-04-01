package codingtest.baekjoon.dfs_bfs.gold;

import java.util.*;
import java.io.*;

public class B14502 {

    static int n, m;
    static int[][] arr = new int[10][10];
    static int[][] visited = new int[10][10];
    static List<Pair> wallList = new ArrayList<>();
    static List<Pair> virusList = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ret = Integer.MIN_VALUE;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(temp[j]);
                if (num == 0) {
                    wallList.add(new Pair(i, j));
                }else if (num == 1) {
                    visited[i][j] = 1;
                } else if (num == 2) {
                    virusList.add(new Pair(i, j));
                    visited[i][j] = 1;
                }
                arr[i][j] = num;
            }
        }

        // 64 * 64 * 64 * 64
        // + 64 * 64 * 64 * 3 * 64 * 64 * 64
        // + 64 * 64 * 64 * 64 * 64 * 64
        for (int i = 0; i < wallList.size(); i++) {
            for (int j = i + 1; j < wallList.size(); j++) {
                for (int k = j + 1; k < wallList.size(); k++) {
                    Pair wall1 = wallList.get(i); visited[wall1.y][wall1.x] = 1;
                    Pair wall2 = wallList.get(j); visited[wall2.y][wall2.x] = 1;
                    Pair wall3 = wallList.get(k); visited[wall3.y][wall3.x] = 1;
                    int[][] tempVisited = new int[10][10];
                    for (int ii = 0; ii < n; ii++) {
                        System.arraycopy(visited[ii], 0, tempVisited[ii], 0, visited[ii].length);
                    }

                    for (Pair virus : virusList) {
                        dfs(virus.y, virus.x, tempVisited);
                    }

//                    System.out.println("===== getSafeArea ====");
                    int safeArea = getSafeArea(tempVisited);
//                    System.out.println(safeArea);

                    ret = Math.max(ret, safeArea);
                    visited[wall1.y][wall1.x] = 0;
                    visited[wall2.y][wall2.x] = 0;
                    visited[wall3.y][wall3.x] = 0;

                }
            }
        }

        System.out.println(ret);


    }

    static int getSafeArea(int[][] visited) {
        int safeArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(arr[i][j] != 0) continue;
                if(visited[i][j] != 0) continue;
                safeArea +=  dfs(i, j, visited);
            }
        }

        return safeArea;
    }

    static int dfs(int y, int x, int[][] visited) {
        visited[y][x] = 1;
        int temp = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(visited[ny][nx] != 0) continue;
            if(arr[ny][nx] != 0) continue;

            temp += dfs(ny, nx, visited);
        }

        return temp;
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
