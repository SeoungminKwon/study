package Algorithms.구현.bronze;

import java.util.Scanner;

public class B1159 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[26];

        int n = sc.nextInt();
        String buffer = sc.nextLine();
        String s = "";
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            String tmp = sc.nextLine();
            arr[tmp.charAt(0) - 97]++;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] >= 5) {
                flag = true;
                System.out.print((char) (i + 97));
            }
        }

        if (flag) {
            return;
        } else {
            System.out.println("PREDAJA");
        }
    }
}
