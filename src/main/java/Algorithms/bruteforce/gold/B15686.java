package Algorithms.bruteforce.gold;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B15686 {
    static int n, m;
    static int[][] a;
    static int result = Integer.MAX_VALUE;
    static List<List<Integer>> chickenList = new ArrayList<>();
    static List<int[]> home = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 1) home.add(new int[] { i, j });
                if (a[i][j] == 2) chicken.add(new int[] { i, j });
            }
        }

        List<Integer> v = new ArrayList<>();
        combi(-1, v);
        for (List<Integer> cList : chickenList) {
            int ret = 0;
            for (int[] h : home) {
                int min = Integer.MAX_VALUE;
                for (int ch : cList) {
                    int[] chickenPos = chicken.get(ch);
                    int dist = Math.abs(h[0] - chickenPos[0]) + Math.abs(h[1] - chickenPos[1]);
                    min = Math.min(min, dist);
                }
                ret += min;
            }
            result = Math.min(result, ret);
        }

        System.out.println(result);

    }

    static void combi(int start, List<Integer> v) {
        if (v.size() == m) {
            chickenList.add(new ArrayList<>(v));
            return;
        }
        for (int i = start + 1; i < chicken.size(); i++) {
            v.add(i);
            combi(i, v);
            v.remove(v.size() - 1);
        }
    }

}
