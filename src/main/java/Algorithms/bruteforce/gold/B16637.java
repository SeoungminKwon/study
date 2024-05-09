package Algorithms.bruteforce.gold;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B16637 {
    static List<Integer> num = new ArrayList<>();
    static List<Character> operStr = new ArrayList<>();
    static int n, ret = Integer.MIN_VALUE;
    static String s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.next();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) num.add(s.charAt(i) - '0');
            else operStr.add(s.charAt(i));
        }
        go(0, num.get(0));
        System.out.println(ret);
        sc.close();
    }

    static int oper(char a, int b, int c) {
        switch (a) {
            case '+': return b + c;
            case '-': return b - c;
            case '*': return b * c;
            default: return 0; // Just to complete the switch
        }
    }

    static void go(int here, int _num) {
        if (here == num.size() - 1) {
            ret = Math.max(ret, _num);
            return;
        }
        go(here + 1, oper(operStr.get(here), _num, num.get(here + 1)));

        if (here + 2 <= num.size() - 1) {
            int temp = oper(operStr.get(here + 1), num.get(here + 1), num.get(here + 2));
            go(here + 2, oper(operStr.get(here), _num, temp));
        }
    }
}


