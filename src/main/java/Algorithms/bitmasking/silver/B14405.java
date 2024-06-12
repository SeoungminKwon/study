package Algorithms.bitmasking.silver;

import java.util.Scanner;

public class B14405 {
    static String s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] pikachu = {"pi", "ka", "chu"};
        s = sc.nextLine();
        int idx = 0;

        boolean ret = true;
        while (idx < s.length()) {
            boolean tmp = false;
            for (String string : pikachu) {
                if(idx + string.length() > s.length())continue;
                String substring = s.substring(idx, idx + string.length());
                if ((substring.equals(string))) {
                    tmp = true;
                    idx += string.length();
                    break;
                }
            }
            if(!tmp){
                ret = false;
                break;
            }
        }
        if (ret) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
