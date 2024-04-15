package Algorithms.구현.bronze;

import java.util.Scanner;

public class B10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] alphabet = new int[26];

        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 97]++;
        }

        for (int i = 0; i < 26; i++) {
            System.out.println(alphabet[i]);
        }
    }
}
