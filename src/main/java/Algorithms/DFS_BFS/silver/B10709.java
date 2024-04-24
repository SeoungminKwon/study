package Algorithms.DFS_BFS.silver;

import java.util.Scanner;

public class B10709 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] ret = new int[n][m];

        String buffer = sc.nextLine();

        for (int i = 0; i < n; i++) {

            String s = sc.nextLine();
            boolean flag = false;
            int cnt = 0;

            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == 'c')flag = true;

                if (flag) {
                    if (s.charAt(j) == 'c') {
                        cnt = 0;
                        ret[i][j] = cnt;
                    } else {
                        cnt++;
                        ret[i][j] = cnt;
                    }
                } else {
                    ret[i][j] = -1;
                }
            }
        }

        for (int[] ints : ret) {
            for (int r : ints) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }
}
