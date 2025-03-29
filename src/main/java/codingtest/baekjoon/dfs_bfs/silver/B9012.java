package codingtest.baekjoon.dfs_bfs.silver;

import java.util.*;
import java.io.*;

public class B9012 {
    static int n;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Stack<Character> st = new Stack<>();
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                if(st.size() == 0) st.add(str.charAt(j));
                else{
                    char peek = st.peek();
                    char c = str.charAt(j);
                    if(peek == '(' && c == ')') st.pop();
                    else st.add(c);
                }
            }

            if (st.size() == 0) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }
}
