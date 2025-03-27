package codingtest.baekjoon.dfs_bfs.silver;

import java.util.*;
import java.io.*;

public class B1992 {
    static int[][] arr = new int[70][70];
    static int n;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                int temp = str.charAt(j) - '0';
                arr[i][j] = temp;
            }
        }

        Pair start = new Pair(0, 0);
        Pair end = new Pair(n - 1, n - 1);
        System.out.println(solve(start, end));

    }

    static class Pair{
        int y;
        int x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static String solve(Pair start, Pair end) {
        if (check(start, end)) {
            return arr[start.y][start.x] + "";
        }else{
            Pair mid = new Pair((start.y + end.y) / 2, (start.x + end.x) / 2);
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(solve(start, mid));
            sb.append(solve(new Pair(start.y, mid.x + 1), new Pair(mid.y, end.x)));
            sb.append(solve(new Pair(mid.y + 1, start.x), new Pair(end.y, mid.x)));
            sb.append(solve(new Pair(mid.y + 1, mid.x + 1), end));
            sb.append(")");
            return sb.toString();
        }
    }

    private static boolean check(Pair start, Pair end){
        int value = arr[start.y][start.x];
        for (int i = start.y; i <= end.y; i++) {
            for (int j = start.x; j <= end.x; j++) {
                if(value != arr[i][j]) return false;
            }
        }
        return true;
    }
}
