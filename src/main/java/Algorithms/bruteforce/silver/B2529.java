package Algorithms.bruteforce.silver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// 0. 정렬된 배열
// 1. 10개 순서 섞기
// 2. 부등호 성립되는지 확인하기

public class B2529 {
    static int n;
    static char[] arr = new char[13];
    static Sign[] signs;
    static int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int[] visited = new int[13];
    static ArrayList<String> result = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String buffer = sc.nextLine();
        String s = sc.nextLine();
        String[] split = s.split(" ");
        signs = Sign.makeArray(split);

        shuffle(new ArrayList<>());
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = removeZero(o1);
                String s2 = removeZero(o2);

                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }else{
                    return s1.length() - s2.length();
                }
            }
        });

        String _min = result.get(0);
        String _max = result.get(result.size() -1);
        System.out.println(_max);
        System.out.println(_min);


    }

    static String removeZero(String s) {
        String ret = "";
        boolean flag = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                flag = true;
            }

            if (flag == false && s.charAt(i) == '0') {
                continue;
            }
            ret += s.charAt(i);
        }
        return ret;
    }

    static String makeString(ArrayList<Integer> arrayList) {
        String s = "";
        for (Integer i : arrayList) {
            s += i;
        }
        return s;
    }

    static void shuffle(ArrayList<Integer> ret){

        if (ret.size() == n + 1) {
            for (int i = 0; i < n; i++) {
                boolean calculate = signs[i].calculate(ret.get(i), ret.get(i + 1));
                if (!calculate) {
                    return;
                }
            }
            result.add(makeString(ret));
        }

        for (int i = 0; i < numbers.length; i++) {
            Integer number = numbers[i];
            if(visited[number] != 0)continue;
            visited[number] = 1;
            ret.add(number);
            shuffle(ret);
            ret.remove(number);
            visited[number] = 0;
        }
    }

    static class Sign{
        String sign;

        public Sign(String sign) {
            this.sign = sign;
        }

        boolean calculate(int a, int b) {
            if (sign.equals(">")) {
                return a > b;
            }
            return a < b;
        }

        static Sign[] makeArray(String[] strings) {
            Sign[] signs = new Sign[strings.length];
            for (int i = 0; i < n; i++) {
                signs[i] = new Sign(strings[i]);
            }
            return signs;
        }
    }
}
