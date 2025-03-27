package codingtest.baekjoon.dfs_bfs.silver;

import java.io.*;
import java.util.*;

public class B10709 {
    static int n, m;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        n = Integer.parseInt(strArr[0]);
        m = Integer.parseInt(strArr[1]);



        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int cloud = -1;
            boolean cloudHistory = false;
            String ret = "";
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                if (c == 'c') {
                    cloud = 0;
                    cloudHistory = true;
                }else{
                    if(cloudHistory) cloud++;
                }

                ret += cloud + " ";
            }

            System.out.println(ret.trim());

        }
    }
}
