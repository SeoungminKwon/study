package Algorithms.구현.silver;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B9375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            String buffer = sc.nextLine();
            Map<String, Integer> mp =new HashMap<>();

            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                String[] split = s.split(" ");
                if (mp.get(split[1]) != null) {
                    mp.put(split[1], mp.get(split[1]) + 1);
                } else {
                    mp.put(split[1], 1);
                }
            }
            int ret = 1;
            for (Integer value : mp.values()) {
                ret *= value + 1;
            }
            System.out.println(ret -1);
        }
    }
}
