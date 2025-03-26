package codingtest.baekjoon.dfs_bfs.silver;

import java.io.*;
import java.util.List;

public class B4659 {
    static List<Character> m = List.of('a', 'e', 'i', 'o', 'u');
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            if(line.equals("end")) break;

            if (checkM(line) && checkThree(line) && checkDouble(line)) {
                System.out.println("<" + line + ">" + " is acceptable.");
            }else{
                System.out.println("<" + line + ">" + " is not acceptable.");
            }
        }
    }

    static boolean checkM (String str) {
        for (char c : str.toCharArray()) {
            if (m.contains(c)) {
                return true;
            }
        }
        return false;
    }

    static boolean checkThree(String str) {
        int mCnt = 0, jCnt = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (m.contains(c)) {
                mCnt++;
                if(mCnt >= 3) return false;
                jCnt = 0;
            }else{
                jCnt++;
                if(jCnt >= 3) return false;
                mCnt = 0;
            }
        }
        return true;
    }



    static boolean checkDouble(String str) {
        for (int i = 1; i < str.length(); i++) {
            char first = str.charAt(i - 1);
            char second = str.charAt(i);

            if ((!(first == 'e' || first == 'o'))
                    && (first == second)) {
                return false;
            }
        }
        return true;
    }
}
