package Algorithms.구현.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class B11655 {
    public static void main(String[] args) {
        // 대문자 유니코드 65 ~ 65+25
        // 소문자 유니코드 97 ~ 97+25

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 65 && c <= 65 + 25) {
                c += 13;
                if (c > 'Z') {
                    c-= 26;
                }
                System.out.print(c);
            } else if (c >= 97 && c <= 97 + 25) {
                c += 13;
                if (c > 'z') {
                    c -= 26;
                }
                System.out.print(c);
            } else {
                System.out.print(c);
            }
        }
    }
}
