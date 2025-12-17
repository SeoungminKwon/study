package codingtest.bfs_dfs.silver;

import java.util.*;
import java.io.*;

public class B4659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            if (input.equals("end")) {
                break;
            }
            solve(input);
        }
    }

    static void solve(String input) {
        int mCnt = 0;
        int jCnt = 0;
        int sameCnt = 0;
        char lastChar = input.charAt(0);
        boolean mFlag = false;
        boolean flag = true;
        if (lastChar == 'a' || lastChar == 'e' || lastChar == 'i' || lastChar == 'o' || lastChar == 'u') {
            mCnt++;
            mFlag = true;
        }else{
            jCnt++;
        }
        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                mCnt++;
                jCnt = 0;
                mFlag = true;
                if(mCnt >= 3){
                    flag = false;
                }
            }else{
                jCnt++;
                mCnt = 0;
                if (jCnt >= 3) {
                    flag = false;
                }
            }

            if (lastChar == c && lastChar != 'e' && lastChar != 'o') {
                flag = false;
            }
            lastChar = c;
        }

        output(input, flag && mFlag);
    }

    static void output(String input, boolean flag) {
        if (flag) {
            System.out.println("<" + input + "> is acceptable.");
        }else{
            System.out.println("<" + input + "> is not acceptable.");
        }
    }
}
