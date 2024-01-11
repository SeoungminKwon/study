package backjun.bronze;

import java.util.Scanner;

public class B10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }

        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
