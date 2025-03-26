package codingtest.baekjoon.dfs_bfs.silver;

import java.util.*;
import java.io.*;

public class B1992 {
    static int n;
    static char[][] arr = new char[70][70];
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            arr[i] = s.toCharArray();
        }


    }

//    static String quard(int y, int x, int size) {
//        if(size == 1) return String.valueOf(arr[y][x]);
//
//
//    }
}
