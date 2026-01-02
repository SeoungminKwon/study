package codingtest.brute_force;

import java.util.*;
import java.io.*;

public class B16234 {

    static int n,l, r;
    static int[][] arr = new int[53][53];
    static int[][] visited = new int[53][53];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int day = 0;
        while (true) {

            visited = new int[53][53];
            boolean isMove = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if(visited[i][j] != 0) continue;
                    List<Pair> moveList = new ArrayList<>();
                    Pair now = new Pair(i, j);
                    moveList.add(now);
                    bfs(now, moveList);

                    if (moveList.size() != 1) {
                        isMove = true;

                        int avg = 0;
                        for (Pair m : moveList) {
                            avg += arr[m.y][m.x];
                        }
                        avg /= moveList.size();

                        for (Pair m : moveList) {
                            arr[m.y][m.x] = avg;
                        }
                    }
                }
            }

            if(!isMove) break;
            day++;
//            System.out.println(day);
        }

        System.out.println(day);
    }


    static void bfs(Pair now, List<Pair> moveList) {
        visited[now.y][now.x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = now.y + dy[i];
            int nx = now.x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if(visited[ny][nx] != 0) continue;

            int diff = Math.abs(arr[now.y][now.x] - arr[ny][nx]);
            if (diff >= l && diff <= r) {
                Pair next = new Pair(ny, nx);
                moveList.add(next);
                bfs(next, moveList);
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
