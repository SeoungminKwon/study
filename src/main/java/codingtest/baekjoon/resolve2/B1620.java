package codingtest.baekjoon.resolve2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 3/6 : 답지봄
 */
public class B1620 {
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();

        n = sc.nextInt();
        m = sc.nextInt();
        String buffer = sc.nextLine();

        for (int i = 1; i <= n; i++) {
            String temp = sc.nextLine();
            map1.put(temp, i);
            map2.put(i, temp);
        }

        for (int i = 0; i < m; i++) {
            String temp = sc.nextLine();
            if (isNumber(temp)) {
                System.out.println(map2.get(Integer.parseInt(temp)));
            }else{
                System.out.println(map1.get(temp));
            }
        }
    }

    static boolean isNumber(String s) {
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!Character.isDigit(c)) flag = false;
        }

        return flag;
    }
}
