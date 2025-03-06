package codingtest.baekjoon.silver;

import java.util.Scanner;

public class B1620 {
    static int n, m;
    static int[] arr = new int[100003];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();



        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for (int i = m; i <= n; i++) {
            int temp = arr[i] - arr[i - m];
            max = Math.max(max, temp);
        }
        System.out.println(max);
    }
}
