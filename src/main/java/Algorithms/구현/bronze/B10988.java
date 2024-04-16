package Algorithms.구현.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class B10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String rs = "";

        for (int i = s.length() -1; i >= 0; i--) {
            rs+= s.charAt(i);
        }

        if (rs.equals(s)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
