package Algorithms.bruteforce.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3197 {
    static int n, m;
    static int[][] arr = new int[1503][1503];
    static Pair swanPoint;
    static int[][] visited = new int[1503][1503];
    static int[][] visitedSwan = new int[1503][1503];
    static Queue<Pair> waterQ = new LinkedList<>();
    static Queue<Pair> waterTempQ = new LinkedList<>();
    static Queue<Pair> swanQ = new LinkedList<>();
    static Queue<Pair> swanTempQ = new LinkedList<>();

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());



        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'L') {
                    swanPoint = new Pair(i, j);
                }
                if(arr[i][j] == 'L' || arr[i][j] == '.'){
                    visited[i][j] = 1;
                    waterQ.add(new Pair(i, j));
                }
            }
        }

        swanQ.add(new Pair(swanPoint.y, swanPoint.x));
        visitedSwan[swanPoint.y][swanPoint.x] = 1;


        int day = 0;
        while (true) {
            if(move()) break;
            melting();
            waterQ = new LinkedList<>(waterTempQ);
            swanQ = new LinkedList<>(swanTempQ);
            waterTempQ.clear();
            swanTempQ.clear();
            day++;
        }

        System.out.println(day);

    }

    static void melting() {
        while (!waterQ.isEmpty()) {
            Pair p = waterQ.poll();
            int y = p.y;
            int x = p.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0|| nx < 0 || ny >= n || nx >= m) continue;
                if(visited[ny][nx] != 0) continue;
                visited[ny][nx] = 1;
                waterTempQ.add(new Pair(ny, nx));
                arr[ny][nx] = '.';
            }
        }
    }

    static boolean move() {
        while (!swanQ.isEmpty()) {
            Pair p = swanQ.poll();
            int y = p.y;
            int x = p.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m)continue;
                if(visitedSwan[ny][nx] != 0)continue;

                visitedSwan[ny][nx] = 1;
                if (arr[ny][nx] == '.') {
                    swanQ.add(new Pair(ny, nx));
                } else if (arr[ny][nx] == 'X') {
                    swanTempQ.add(new Pair(ny, nx));
                }else if (arr[ny][nx] == 'L') {
                    return true;
                }
            }
        }
        return false;
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
