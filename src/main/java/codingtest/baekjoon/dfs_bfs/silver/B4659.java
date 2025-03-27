package codingtest.baekjoon.dfs_bfs.silver;

import java.io.*;
import java.util.List;

public class B4659 {
    static List<Character> mList = List.of('a', 'e', 'i', 'o', 'u');
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        while (!input.equals("end")) {
            input = br.readLine();
            if (input.equals("end")) {
                System.exit(0);
            }else{
                solve(input);
            }
        }

    }

    static void  solve(String str) {

//        System.out.println("str : " + str + " solve1 : " + solve1(str) + " solve2 : " + solve2(str) + " solve3 : " + solve3(str));

         if(solve1(str) && solve2(str) && solve3(str)){
             System.out.printf("<%s> is acceptable.\n", str);
         }else{
             System.out.printf("<%s> is not acceptable.\n", str);
         }
    }

    static boolean solve1(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(mList.contains(c))return true;
        }
        return false;
    }

    static boolean solve2(String str) {
        int mCnt = 0;
        int jCnt = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (mList.contains(c)) {
                mCnt++;
                if(isOverThree(mCnt)) return false;
                jCnt = 0;
            }else{
                mCnt = 0;
                jCnt++;
                if(isOverThree(jCnt)) return false;
            }
        }
        return true;
    }

    static boolean solve3(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            char now = str.charAt(i);
            char next = str.charAt(i + 1);
            if (now == next) {
                if(now != 'e' && now != 'o') return false;
            }
        }
        return true;
    }

    static boolean isOverThree(int cnt) {
        if(cnt >= 3) return true;
        return false;
    }
}
