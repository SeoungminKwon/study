package codingtest.baekjoon.dfs_bfs.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1436 {
    static int n;
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); n--;
        long ret = 666;
        while (n != 0) {
            ret++;
            String temp = ret + "";
            if (temp.contains("666")) {
                n--;
            }
        }

        System.out.println(ret);
    }
}
