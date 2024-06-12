package Algorithms.bitmasking.silver;

import java.util.Scanner;

public class B15353 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        System.out.println(strAdd(a, b));

    }

    static String strAdd(String a, String b) {
        int n = a.length() > b.length() ? a.length() : b.length();
        String flag = a.length() > b.length() ? "a" : "b";
        String ret = "";
        int up = 0;
        a = reverseStr(a);
        b = reverseStr(b);

        for (int i = 0; i < n; i++) {
            int tmp = up == 1 ? 1 : 0;
            if (a.length() > i && b.length() > i) {
                int numA = a.charAt(i) - '0';
                int numB = b.charAt(i) - '0';
                int[] tmpArr = upAndNum(numA, numB); up = tmpArr[0]; tmp = tmpArr[1];
            } else {
                if (flag.equals("a")) {
                    int numA = a.charAt(i) - '0';
                    int[] tmpArr = upAndNum(numA, tmp); up = tmpArr[0]; tmp = tmpArr[1];
                } else {
                    int numB = a.charAt(i) -'0';
                    int[] tmpArr = upAndNum(numB, tmp); up = tmpArr[0]; tmp = tmpArr[1];
                }
            }
            ret = tmp + ret;
        }
        if(up == 1) ret = "1" + ret;
        return ret;
    }

    static int[] upAndNum(int num1, int num2) {
        int[] ints = new int[2];
        if (num1 + num2 >= 10) {
            ints[0] = 1;
            ints[1] = num1 + num2 - 10;
        } else{
            ints[0] = 0;
            ints[1] = num1 + num2;
        }
        return ints;
    }

    static String reverseStr(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}

