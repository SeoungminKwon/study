package Algorithms.bruteforce.gold;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B12869 {
    static int[] dmg = {9, 3, 1};
    static int[][][] visited = new int[64][64][64];
    static int[][][] scv = new int[64][64][64];
    static int[][] scvAttack = {
            {0, 1, 2},
            {0, 2, 1},
            {1, 0, 2},
            {1, 2, 0},
            {2, 0, 1},
            {2, 1, 0}
    };
    static int result = Integer.MAX_VALUE;
    static int[] scvInput = new int[3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            scvInput[i] = sc.nextInt();
        }


        Queue<TreeScv> queue = new LinkedList<>();
        visited[scvInput[0]][scvInput[1]][scvInput[2]] = 1;
        queue.add(new TreeScv(scvInput[0], scvInput[1], scvInput[2]));

        while (!queue.isEmpty()) {
            if(visited[0][0][0] != 0)break;
            TreeScv scvs = queue.poll();
            int a = scvs.scv1;
            int b = scvs.scv2;
            int c = scvs.scv3;
            for (int i = 0; i < 6; i++) {
                int na = Math.max(0, a - dmg[scvAttack[i][0]]);
                int nb = Math.max(0, b - dmg[scvAttack[i][1]]);
                int nc = Math.max(0, c - dmg[scvAttack[i][2]]);
                if(visited[na][nb][nc] != 0)continue;
                visited[na][nb][nc] = visited[a][b][c] + 1;
                queue.add(new TreeScv(na, nb, nc));
            }
        }
        System.out.println(visited[0][0][0] -1);
    }

    static class TreeScv{
        int scv1;
        int scv2;
        int scv3;

        public TreeScv(int scv1, int scv2, int scv3) {
            this.scv1 = scv1;
            this.scv2 = scv2;
            this.scv3 = scv3;
        }
    }
}
