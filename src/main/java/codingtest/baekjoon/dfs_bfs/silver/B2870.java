package codingtest.baekjoon.dfs_bfs.silver;

import java.util.*;
import java.io.*;

public class B2870 {
    static int n;
    static List<String> strList = new ArrayList<>();
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());




        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (!isAlpha(c)) {
                    sb.append(c);
                }else{
                    if (sb.length() > 0) {
                        String temp = sb.toString();
                        String ret = removeZero(temp);
                        strList.add(ret);
                        sb = new StringBuilder();
                    }else continue;
                }

                if (j == str.length() - 1) {
                    if (sb.length() > 0) {
                        String temp = sb.toString();
                        String ret = removeZero(temp);
                        strList.add(ret);
                        sb = new StringBuilder();
                    }
                }
            }
        }


        Collections.sort(strList, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }else{
                    return s1.length() - s2.length();
                }
            }
        });

        for (String ret : strList) {
            System.out.println(ret);
        }
    }

    static String removeZero(String str) {
        boolean zeroCheck = true;

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != '0') zeroCheck = false;
        }

        if (zeroCheck) {
            return "0";
        } else {
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c != '0') flag = true;
                if (flag) sb.append(c);
            }
            return sb.toString();
        }
    }

    static boolean isAlpha(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }else return false;
    }
}
