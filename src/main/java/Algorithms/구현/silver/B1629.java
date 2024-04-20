package Algorithms.구현.silver;

import java.util.Scanner;

public class B1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        System.out.println(go(a, b, c));
    }

    static long go(long a, long b, long c) {
        if(b == 1) return a % c;
        long ret = go(a, b/2, c);
        ret = ret*ret % c;
        if (b % 2 == 1) {
            ret = (a * ret) % c;
        }
        return ret;
    }
}
