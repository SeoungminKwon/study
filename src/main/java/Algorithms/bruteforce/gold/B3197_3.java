package Algorithms.bruteforce.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;


public class B3197_3 {

    static final int MAX_N = 1501;
    static final int[] DX = {1, 0, -1, 0};
    static final int[] DY = {0, 1, 0, -1};
    static int[][] visitedSwan = new int[MAX_N][MAX_N];
    static int[][] visited = new int[MAX_N][MAX_N];
    static int R, C, day, swanY, swanX, y, x;
    static char[][] a = new char[MAX_N][MAX_N];
    static Queue<Pair> waterQ = new LinkedList<>();
    static Queue<Pair> waterTempQ = new LinkedList<>();
    static Queue<Pair> swanQ = new LinkedList<>();
    static Queue<Pair> swanTempQ = new LinkedList<>();

    public static void Qclear(Queue<Pair> q) {
        q.clear();
    }

    public static void waterMelting() {
        while (!waterQ.isEmpty()) {
            Pair p = waterQ.poll();
            y = p.y;
            x = p.x;
            for (int i = 0; i < 4; i++) {
                int ny = y + DY[i];
                int nx = x + DX[i];
                if (ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx] == 1) continue;
                if (a[ny][nx] == 'X') {
                    visited[ny][nx] = 1;
                    waterTempQ.add(new Pair(ny, nx));
                    a[ny][nx] = '.';
                }
            }
        }
    }

    public static boolean moveSwan() {
        while (!swanQ.isEmpty()) {
            Pair p = swanQ.poll();
            y = p.y;
            x = p.x;
            for (int i = 0; i < 4; i++) {
                int ny = y + DY[i];
                int nx = x + DX[i];
                if (ny < 0 || ny >= R || nx < 0 || nx >= C || visitedSwan[ny][nx] == 1) continue;
                visitedSwan[ny][nx] = 1;
                if (a[ny][nx] == '.') swanQ.add(new Pair(ny, nx));
                else if (a[ny][nx] == 'X') swanTempQ.add(new Pair(ny, nx));
                else if (a[ny][nx] == 'L') return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine(); // Consume newline
        for (int i = 0; i < R; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < C; j++) {
                a[i][j] = s.charAt(j);
                if (a[i][j] == 'L') {
                    swanY = i;
                    swanX = j;
                }
                if (a[i][j] == '.' || a[i][j] == 'L') {
                    visited[i][j] = 1;
                    waterQ.add(new Pair(i, j));
                }
            }
        }
        swanQ.add(new Pair(swanY, swanX));
        visitedSwan[swanY][swanX] = 1;

        while (true) {
            if (moveSwan()) break;
            waterMelting();
            waterQ = new LinkedList<>(waterTempQ);
            swanQ = new LinkedList<>(swanTempQ);
            Qclear(waterTempQ);
            Qclear(swanTempQ);
            day++;
        }
        System.out.println(day);
    }

    static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
