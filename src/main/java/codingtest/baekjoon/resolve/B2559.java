package codingtest.baekjoon.resolve;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B2559 {
    static int n, m;
    static Map<String, Integer> pok1 = new HashMap<>();
    static Map<Integer, String> pok2 = new HashMap<>();;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        String buffer = sc.nextLine();

        for (int i = 1; i <= n; i++) {
            String temp = sc.nextLine();
            pok1.put(temp, i);
            pok2.put(i, temp);
        }

        for (int i = 0; i < m; i++) {
            String temp = sc.nextLine();
            try {
                int number = Integer.parseInt(temp);
                System.out.println(pok2.get(number));
            } catch (Exception e) {
                Integer i1 = pok1.get(temp);
                System.out.println(i1);
            }
        }
    }


}
