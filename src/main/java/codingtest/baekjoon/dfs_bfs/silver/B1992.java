package codingtest.baekjoon.dfs_bfs.silver;

import java.util.*;
import java.io.*;

public class B1992 {
    static int n;
    static char[][] charArr = new char[70][70];
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = temp.charAt(j);
                charArr[i][j] = c;
            }
        }

        Pair start = new Pair(0, 0);
        Pair end = new Pair(n - 1, n - 1);

        String ret = solve(start, end);
        System.out.println(ret);


    }

    static class Pair{
        int y;
        int x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static String solve(Pair start, Pair end) {
        if (check(start, end)) {
            return charArr[start.y][start.x] + "";
        }else{
            Pair mid = new Pair((start.y + end.y) / 2, (start.x + end.x) / 2);
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(solve(start, new Pair(mid.y, mid.x)));
            sb.append(solve(new Pair(start.y, mid.x + 1), new Pair(mid.y, end.x)));
            sb.append(solve(new Pair(mid.y + 1, start.x), new Pair(end.y, mid.x)));
            sb.append(solve(new Pair(mid.y + 1, mid.x + 1), end));
            sb.append(")");
            return sb.toString();
        }
    }

    static boolean check(Pair start, Pair end) {
        char first = charArr[start.y][start.x];

        for (int i = start.y; i <= end.y; i++) {
            for (int j = start.x; j <= end.x; j++) {
                if(first != charArr[i][j]) return false;
            }
        }
        return true;
    }
}
