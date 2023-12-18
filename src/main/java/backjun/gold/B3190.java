package backjun.gold;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class B3190 {
    static int n;
    static int k;
    static int l;
    static int x;
    static char c;
    static Deque< PairVec > pairVecs = new ArrayDeque<>();
    static Deque< PairNow > pairNows = new ArrayDeque<>();

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] arr = new int[104][104];
    static int[][] arr2 = new int[104][104];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            arr[--y][--x] =1;
        }

        int l = sc.nextInt();
        for (int i = 0; i < l; i++) {
            x = sc.nextInt();
            c = sc.next().charAt(0);
            pairVecs.add(new PairVec(x, c));
        }

        pairNows.add(new PairNow(0, 0));
        int dir = 1;
        int cnt = 0;
        while (true) {

            cnt++;
            int ny = pairNows.getFirst().y + dy[dir % 4];
            int nx = pairNows.getFirst().x + dx[dir % 4];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n)break;
            if(arr2[ny][nx] == 1)break;

            if(arr[ny][nx] == 1){
                pairNows.addFirst(new PairNow(ny, nx));
                arr2[ny][nx] = 1;
                arr[ny][nx] = 0;
            }else{
                PairNow pairNow = pairNows.removeLast();
                arr2[pairNow.y][pairNow.x] = 0;
                pairNows.addFirst(new PairNow(ny, nx));
                arr2[ny][nx] = 1;
            }

            if (!pairVecs.isEmpty() && pairVecs.getFirst().time == cnt){
                if (pairVecs.getFirst().vec == 'L') {
                    dir = dir +3;
                }else{
                    dir++;
                }
                pairVecs.removeFirst();
            }

        }
        System.out.println(cnt);

    }
    static class PairVec{
        int time;
        char vec;

        public PairVec(int time, char vec) {
            this.time = time;
            this.vec = vec;
        }
    }

    static class PairNow{
        int y;
        int x;

        public PairNow(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
