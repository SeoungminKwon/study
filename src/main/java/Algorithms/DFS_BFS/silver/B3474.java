package Algorithms.DFS_BFS.silver;

import java.util.Scanner;

public class B3474 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long t = sc.nextLong();

        for (long tc = 0; tc < t; tc++) {
            long input = sc.nextLong();

            long cnt2 = 0;
            long cnt5 = 0;

            for (long i = 2; i <= input; i *= 2) {
                cnt2 += input / i;
            }
            for (long i = 5; i <= input; i *= 5) {
                cnt5 += input / i;
            }
            System.out.println(Math.min(cnt2, cnt5));
        }
    }
}
