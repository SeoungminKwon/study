package Algorithms.grid_twopointer_lineswiping.gold;

import java.util.LinkedList;
import java.util.Queue;

public class B2048 {
    // 전체 블록을 상하좌우 네 방향 중 하나로 이동가능
    // 두 블록이 충돌하면 두 블록을 합쳐지개 됨
    // 한 번의 이동에서 이미 합쳐진 블록은 또 다른 블록과 합쳐질 수 없다.
    // 1 <= n <= 20
    public static void main(String[] args){

    }
    static class Board{
        int[][] arr;
        int n;

        Board(int n) {
            arr = new int[n][n];
            this.n = n;
        }

        public void moveLeft() {
            int[][] na = makeNewArr();

            for (int i = 0; i < n; i++) {
                Queue<Integer> q = new LinkedList<>();
                for (int j = 0; j < n; j++) {
                    if(arr[i][j] == 0) continue;
                    q.add(arr[i][j]);
                }

                int prev = -1;
                for (int tmp : q) {
                    if(prev == -1) prev = tmp;
                    else{

                    }
                }
            }
        }

        public void moveRight() {

        }

        public void moveUp() {

        }

        public void moveDown() {

        }

        private int[][] makeNewArr() {
            return new int[n][n];
        }
    }
}
