package Algorithms.bitmasking.silver;

import java.util.Scanner;

public class B1094 {
    static int n;
    static int ret;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < 7; i++) {
            if((n & (1 << i)) != 0) ret++;
        }
        System.out.println(ret);
    }
}
