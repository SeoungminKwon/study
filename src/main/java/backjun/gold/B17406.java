package backjun.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class B17406 {

    static int n, m, k;
    static int[][] a;
    static List< Rotate > rotateList = new ArrayList<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < k; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int s = sc.nextInt();
            rotateList.add(new Rotate(r-1, c-1, s));
        }

//        permutation();


    }

    static int[][] cpy() {
        int[][] tmp = new int[53][53];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = a[i][j];
            }
        }
        return tmp;
    }

    static void rot(int y, int x, int cnt){

        int[][] tmp = cpy();



        for (int i = 1; i <= cnt; i++) {
            int sy = y - i;
            int sx = x - i;
            int ey = y + i;
            int ex = x + i;
            int dir = 0;
            Queue< Pair > queue = new LinkedList<>();
            queue.add(new Pair(sy, sx));

            List< Pair > pairList = new ArrayList<>();
            pairList.add(new Pair(sy, sx));
            Queue< Integer > queue2 = new LinkedList<>();
            queue2.add(tmp[sy][sx]);


            while (!queue.isEmpty()) {
                Pair p = queue.poll();
                int nowY = p.y;
                int nowX = p.x;


                int ny = nowY + dy[dir];
                int nx = nowX + dx[dir];
                if (ny < sy || nx < sx || ny > ey || nx > ex){
                    dir++;
                    ny = nowY + dy[dir];
                    nx = nowX + dx[dir];
                }
                if(ny == sy && nx == sx)break;
                if(dir == 4)break;
                queue.add(new Pair(ny, nx));
                queue2.add(tmp[ny][nx]);
                pairList.add(new Pair(ny, nx));

            }

            Integer itg = queue2.poll();
            queue2.add(itg);

            for (Pair pair : pairList) {
                tmp[pair.y][pair.x] = queue2.poll();
            }

        }



    }

    static void permutation(int now, int[] b, int[] visited) {
        if (now == k) {
            for (int i : b) {
                Rotate rotate = rotateList.get(i);
                rot(rotate.y, rotate.x, rotate.cnt);
            }



        }
    }
}

class Pair{
    int y;
    int x;

    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Rotate{
    int y, x, cnt;

    public Rotate(int y, int x, int cnt) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }
}