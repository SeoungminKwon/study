package codingtest.bfs_dfs.silver;

import java.util.*;
import java.io.*;

public class B1992 {
    static int n;
    static int[][] arr = new int[70][70];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.println(solve(new Pair(0, 0), n));




    }

    static String solve(Pair start, int length) {
        if (check(start, length)) {
            return arr[start.y][start.x] + "";
        }else{
            return
                    "(" +
                            solve(start, length / 2) +
                            solve(new Pair(start.y, start.x + length / 2), length / 2) +
                            solve(new Pair(start.y + length / 2, start.x), length / 2) +
                            solve(new Pair(start.y + length / 2, start.x + length / 2), length / 2) +
                    ")";
        }
    }

    static boolean check(Pair start, int length) {
        int checkPoint = arr[start.y][start.x];

        for (int i = start.y; i < start.y + length; i++) {
            for (int j = start.x; j < start.x + length; j++) {
                if(arr[i][j] != checkPoint) return false;
            }
        }
        return true;
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
