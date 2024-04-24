package Algorithms.DFS_BFS.silver;

import java.util.Scanner;

public class B4659 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String s = sc.nextLine();
            if(s.equals("end"))break;

            boolean aeiou = false;
            int j = 0;
            int m = 0;
            int prev = 0;
            boolean success = true;

            if (s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i' || s.charAt(0) == 'o'
                        || s.charAt(0) == 'u') {
                j++;
                aeiou = true;
            }else{
                m++;
            }

            prev = s.charAt(0);

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
                            || s.charAt(i) == 'u') {
                    j++;
                    m = 0;
                    aeiou = true;
                }else{
                    j = 0;
                    m++;
                }

                if (j >= 3 || m >= 3) {
                    success = false;
                    break;
                }

                if (prev != 'o' && prev != 'e') {
                    if (prev == s.charAt(i)) {
                        success = false;
                        break;
                    }
                }
                prev = s.charAt(i);
            }

            if (success && aeiou) {
                System.out.println("<" + s + "> " + "is acceptable.");
            } else {
                System.out.println("<" + s + "> " + "is not acceptable.");
            }
        }
    }
}
