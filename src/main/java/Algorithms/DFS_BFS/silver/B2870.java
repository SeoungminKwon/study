package Algorithms.DFS_BFS.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class B2870 {
    static ArrayList<String> ret = new ArrayList<>();
    public static void main(String[] args) {
        // 0 단독으로 만 있을 떈 0으로 인정
        // 003 이런 경우는 3으로 인정
        // 100개 줄이 모두 있을 경우는 int로 처리 불가
        // String으로 처리하는데
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String buffer = sc.nextLine();

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            solve(s);
        }

        Collections.sort(ret, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    for (int i = 0; i < o1.length(); i++) {
                        if(o1.charAt(i) == o2.charAt(i))continue;
                        return o1.charAt(i) - o2.charAt(i);
                    }
                }
                return o1.length() - o2.length();
            }
        });

        for (String s : ret) {
            System.out.println(s);
        }
    }

    static void solve(String s) {
        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                tmp += s.charAt(i);
            } else {
                // 앞의 0 처리 과정 필요
                if (!tmp.isEmpty()) {
                    tmp = reduceZero(tmp);
                    ret.add(tmp);
                }

                tmp = "";
            }
        }

        if (!tmp.isEmpty()) {
            tmp = reduceZero(tmp);
            ret.add(tmp);
        }
    }

    static String reduceZero(String s) {
        boolean flag = false;
        String r = "";

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '0')flag = true;

            if (flag) {
                r += s.charAt(i);
            }
        }
        if (r.isEmpty()) {
            return "0";
        }else{
            return r;
        }
    }
}
