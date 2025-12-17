package codingtest.create.silver;

import java.util.*;
import java.io.*;

public class B1629 {
    static int a, b, c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        System.out.println(solve(b));
    }

    static long solve(int now) {
        if (now == 1) {
            return a % c;
        }

        if (now % 2 == 1) {
            long temp = solve(now / 2) % c;
            temp = (temp * temp) % c;
            temp = (temp * a) % c;
            return temp;
        }else{
            long temp = solve(now / 2) % c;
            temp = (temp * temp) % c;
            return temp;
        }


    }
}
