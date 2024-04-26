package Algorithms.DFS_BFS.gold;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class B14502 {
    static int[][] arr = new int[10][10];
    static int[][] visited;
    static ArrayList<Pair> wallList = new ArrayList<>();
    static ArrayList<Pair> virusList = new ArrayList<>();
    static int n;
    static int m;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int ret = Integer.MIN_VALUE;



        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 0) {
                    wallList.add(new Pair(i, j));
                } else if (arr[i][j] == 2) {
                    virusList.add(new Pair(i, j));
                }
            }
        }

        for (int i = 0; i < wallList.size(); i++) {
            for (int j = i + 1; j < wallList.size(); j++) {
                for (int k = j + 1; k < wallList.size(); k++) {
                    createWall(i, j, k, true);
                    visited = new int[10][10];
                    for (Pair pair : virusList) {
                        if(visited[pair.y][pair.x] != 0)continue;
                        dfs(pair.y, pair.x);
                    }
                    ret = Math.max(ret, count());
                    createWall(i, j, k, false);
                }
            }
        }
        System.out.println(ret);
    }

    static void createWall(int i, int j, int k, boolean b) {
        Pair w1 = wallList.get(i);
        Pair w2 = wallList.get(j);
        Pair w3 = wallList.get(k);
        if (b) {
            arr[w1.y][w1.x] = 1;
            arr[w2.y][w2.x] = 1;
            arr[w3.y][w3.x] = 1;
        } else {
            arr[w1.y][w1.x] = 0;
            arr[w2.y][w2.x] = 0;
            arr[w3.y][w3.x] = 0;
        }
    }



    static void dfs(int y, int x) {
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny  = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m)continue;
            if(arr[ny][nx] != 0)continue;
            if(visited[ny][nx] != 0)continue;
            dfs(ny, nx);
        }
    }

    static int count() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j] != 0)continue;
                if (arr[i][j] == 0)cnt++;
            }
        }
        return cnt;
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
