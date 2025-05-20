package codingtest.baekjoon.bruthforce.gold;

import java.io.*;
import java.util.*;

public class B1987 {
    static int n, m;
    static char[][] arr = new char[23][23];
    static int[][] visited = new int[23][23];

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = temp.charAt(j);
            }
        }

        Queue<PairWithPath> q = new LinkedList<>();
        List<Pair> path = new ArrayList<>();
        Pair startNode = new Pair(0, 0);

        q.add(new PairWithPath(startNode, path));
        visited[0][0] = 1;

        while (!q.isEmpty()) {
            PairWithPath now = q.poll();
            List<Pair> moveList = now.path;

            for (int i = 0; i < 4; i++) {
                int ny = now.pair.y + dy[i];
                int nx = now.pair.x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m)continue;
                if(visited[ny][nx] != 0) continue;
                boolean pathFlag = false;

                System.out.println("===== moveList =====");
                for (int k = 0; k < moveList.size(); k++) {
                    Pair pair = moveList.get(k);
                    System.out.println(arr[pair.y][pair.x]);
                }

                for (Pair p : moveList) {
                    if(arr[p.y][p.x] == arr[ny][nx]){
                        System.out.println("경로상 같은 알파벳이 존재 ");
                        pathFlag = true;
                        break;
                    }
                }
                if(pathFlag) continue;

                Pair next = new Pair(ny, nx);
                List<Pair> nextPath = new ArrayList<>(moveList);
                nextPath.add(next);
                q.add(new PairWithPath(next, nextPath));
                visited[ny][nx] = visited[now.pair.y][now.pair.x] + 1;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, visited[i][j]);
            }
        }

        System.out.println(max);




    }

    static class PairWithPath{
        Pair pair;
        List<Pair> path;

        PairWithPath(Pair p, List<Pair> path) {
            this.pair = p;
            this.path = path;
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
