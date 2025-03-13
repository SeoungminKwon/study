package codingtest.baekjoon.silver;

import java.util.Scanner;

public class B1629 {
    static long a, b, c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextLong();
        b = sc.nextLong();
        c = sc.nextLong();

        long ret = solve(b);
        System.out.println(ret);
    }

    static long solve(long n){
        if (n == 1) {
            long ret = a % c;
            return ret;

        }
        if (n % 2 == 0) {
            long ret = solve(n / 2) * solve(n / 2);
            ret %= c;
            return ret;

        }else{
            long ret = ((solve(n / 2) * solve(n / 2)) % c) * (a % c);
            ret %= c;
            return ret;

        }
    }


}
