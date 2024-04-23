package Algorithms.DFS_BFS.silver;

import java.util.Scanner;

public class B1992 {
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String buffer = sc.nextLine();
        arr = new int[70][70];

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(go(0, 0, n));

    }

    static String go(int y, int x, int n) {
        if (check(y, x, n)) {
            return Integer.toString(arr[y][x]);
        }

        return "("
                       + go(y, x, n / 2)
                       + go(y, x + n / 2, n / 2)
                       + go(y + n / 2, x, n / 2)
                       + go(y + n / 2, x + n / 2, n / 2)
                       + ")";
    }

    static boolean check(int y, int x, int n) {
        boolean flag = true;
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if(arr[y][x] != arr[i][j])flag = false;
                if(flag == false) break;
            }
            if(flag == false)break;
        }
        return flag;
    }


}
