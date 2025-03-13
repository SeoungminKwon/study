package codingtest.baekjoon.silver;

import java.util.Scanner;

public class B4375 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLong()) {
            long n = sc.nextLong();
            long remainder = 0;
            int length = 0;

            while (true) {
                remainder = (remainder * 10 + 1) % n;
                length++;
                if (remainder == 0) {
                    System.out.println(length);
                break;
                }
            }
        }
    }
}
