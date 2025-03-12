package codingtest.baekjoon.silver;

import java.util.Calendar;
import java.util.Scanner;

public class B1213 {
    static int[] alpha = new int[26];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'A']++;
        }

        int flag = 0;
        StringBuffer sbLeft = new StringBuffer();
        StringBuffer sbRight = new StringBuffer();
        String middle = "";
        for (int i = 0; i < alpha.length; i++) {
            if(alpha[i] % 2 != 0) flag++;
            if (flag > 1) {
                System.out.println("I'm Sorry Hansoo");
                System.exit(0);
            }

            if (alpha[i] % 2 == 0) {
                int half = alpha[i] / 2;
                for (int j = 0; j < half; j++) {
                    sbRight.insert(0, (char)(i + 'A'));
                    sbLeft.append((char)(i + 'A'));
                }
            }else{
                Character c = (char) (i + 'A');
                middle = c.toString();

                int half = alpha[i] / 2;
                for (int j = 0; j < half; j++) {
                    sbRight.insert(0, (char)(i + 'A'));
                    sbLeft.append((char)(i + 'A'));
                }
            }
        }

        String res = sbLeft.toString() + middle + sbRight.toString();
        System.out.println(res);

    }
}
