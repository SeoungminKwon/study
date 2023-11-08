package backjun._10808;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int a[] = new int[26];
        for(int i = 0; i < s.length(); i++){
            a[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            System.out.print(a[i] + " ");
        }
    }
}
