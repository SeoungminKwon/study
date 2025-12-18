package codingtest.bfs_dfs.gold;

import java.util.*;
import java.io.*;

public class B2636 {

    static int n,m;
    static int[][] arr = new int[103][103];
    static int[][] visited = new int[103][103];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<Pair> cheeseList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        int[][] lastCheese = new int[103][103];

        while (true) {


            // 조건 검사
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] == 1){
                        flag = false;
                        break;
                    }
                }
                if(!flag) break;
            }

            if (!flag) {
                day++;
            }else{
                break;
            }

            // 초기화, 전 배열 복사
            visited = new int[103][103];
            cheeseList = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                System.arraycopy(arr[i], 1, lastCheese[i], 1, m);
            }


//            System.out.println(day);
//            int cnt = 0;
//            for (int i = 1; i <= n; i++) {
//                for (int j = 1; j <= m; j++) {
//                    if(lastCheese[i][j] == 1) cnt++;
//                }
//            }

//            System.out.println(cnt);



            // bfs
            bfs(0, 0);


            // 녹이기
            for (Pair melt : cheeseList) {
                arr[melt.y][melt.x] = 0;
            }


//            // 로깅
//            System.out.println("================================");
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.print(arr[i][j]);
//                }
//                System.out.println();
//            }

        }

        System.out.println(day);
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(lastCheese[i][j] == 1) cnt++;
            }
        }

        System.out.println(cnt);




    }

    static void bfs(int y, int x) {
        visited[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny > n || nx < 0 || nx > m) continue;
            if(visited[ny][nx] != 0) continue;
            if (arr[ny][nx] == 1) {
                cheeseList.add(new Pair(ny, nx));
                continue;
            }
            bfs(ny, nx);
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
