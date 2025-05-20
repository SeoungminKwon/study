package codingtest.baekjoon.bruthforce.platinum;

import java.util.*;
import java.io.*;

public class B3197 {
    static int n, m;
    static char[][] arr = new char[1503][1503];
    static int[][] visited = new int[1503][1503];
    static int day = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        List<Pair> swans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = temp.charAt(j);
                if(arr[i][j] == 'L'){
                    swans.add(new Pair(i, j));
                    visited[i][j] = 1;
                }
            }
        }





        while (true) {

            // bfs로 만났는지 체크
            if (isSwanMeet(swans)) {
                break;
            }
            // 얼음 녹이기
            day++;
            melt();
        }

        System.out.println(day);
    }

    static boolean isSwanMeet(List<Pair> swans) {
        int[][] visitedSwan = new int[1503][1503];
        Queue<Pair> q = new LinkedList<>();

        Pair start = swans.get(0);
        q.add(start);
        visitedSwan[start.y][start.x] = 1;
        Pair destination = swans.get(1);

        while (!q.isEmpty()) {
            Pair now = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(visitedSwan[ny][nx] != 0) continue;
                if(arr[ny][nx] == 'X') continue;
                if (ny == destination.y && nx == destination.x) {
                    return true;
                }
                q.add(new Pair(ny, nx));
                visitedSwan[ny][nx] = 1;
            }

//            System.out.println("======== visitedSwan =========");
//            debug(visitedSwan);
        }

        return false;
    }

    static void melt() {

        List<Pair> meltList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j] != 0) continue;
                if (arr[i][j] == '.' || arr[i][j] == 'L') {
                    dfs(new Pair(i, j), meltList);
                }
            }
        }

//        System.out.println("======= meltList ======");
        for (Pair melt : meltList) {
//            System.out.println(melt.y + " : " + melt.x);
            arr[melt.y][melt.x] = '.';
        }

//        System.out.println("======== after melt day : "+day+" =======");
//        debug(arr);
    }

    static void dfs(Pair now, List<Pair> meltList) {
        visited[now.y][now.x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = now.y + dy[i];
            int nx = now.x + dx[i];
            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if(visited[ny][nx] != 0) continue;

            if (arr[ny][nx] == 'X') {
                meltList.add(new Pair(ny, nx));
                continue;
            }

            dfs(new Pair(ny, nx), meltList);
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

//    static void debug(char[][] arr) {
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
//    }
//
//    static void debug(int[][] arr) {
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
//    }


}
