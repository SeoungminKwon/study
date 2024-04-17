package Algorithms.구현.silver;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B1620 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String buffer = sc.nextLine();
        Map<Integer, String> mp1 = new HashMap<>();
        Map<String, Integer> mp2 = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String s = sc.nextLine();
            mp1.put(i, s);
            mp2.put(s, i);
        }

        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            char c = s.charAt(0);
            if (c >= 65 && c < 65 + 26) {
                System.out.println(mp2.get(s));
            }else {
                System.out.println(mp1.get(Integer.parseInt(s)));
            }
        }

    }
}
