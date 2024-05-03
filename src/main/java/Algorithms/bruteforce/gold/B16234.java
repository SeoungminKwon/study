package Algorithms.bruteforce.gold;

import Algorithms.bruteforce.gold.B2589.Pair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class B16234 {

    static int[][] arr = new int[53][53];
    static int[][] visited = new int[53][53];
    static Map<Integer, ArrayList<Pair>> move;
    static int n, l, r;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while(visited[n-1][n-1] != n*n){

//            System.out.println("day : " +day + " visited[n-1][n-1] : " + visited[n-1][n-1] + " n*n : " + n*n);
//            System.out.println("================================");
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(visited[i][j] + " ");
//                }
//                System.out.println();
//            }

            visited = new int[53][53];
            move = new HashMap<>();

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visited[i][j] != 0)continue;
                    cnt++;

                    bfs(i, j, cnt);
                }
            }

            for (Entry<Integer, ArrayList<Pair>> entry : move.entrySet()) {
                 int area = entry.getKey();
                ArrayList<Pair> value = entry.getValue();

                int sum = 0;
                for (Pair pair : value) {
                    sum += arr[pair.y][pair.x];
                }
                int avg = sum / value.size();
                for (Pair pair : value) {
                    arr[pair.y][pair.x] = avg;
                }
            }


            day++;
        }
        System.out.println(day-1);

    }

    static void bfs(int y, int x, int cnt){
        visited[y][x] = cnt;
        ArrayList<Pair> arrayList = move.getOrDefault(cnt, new ArrayList<>());
        arrayList.add(new Pair(y, x));
        move.put(cnt, arrayList);

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n)continue;
            if(visited[ny][nx] != 0)continue;
            int abs = Math.abs(arr[y][x] - arr[ny][nx]);
            if(!(abs <= r && abs >= l))continue;
            bfs(ny, nx, cnt);
        }
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




