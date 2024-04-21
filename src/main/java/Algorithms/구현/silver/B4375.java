package Algorithms.구현.silver;

import java.util.Scanner;

public class B4375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();

            int cnt = 1;
            int ret = 1;

            while (true) {
                if (ret % n == 0) {
                    System.out.println(cnt);
                    break;
                } else {
                    ret = (ret * 10) % n + 1;
                }
                cnt++;
            }
        }
    }
}
