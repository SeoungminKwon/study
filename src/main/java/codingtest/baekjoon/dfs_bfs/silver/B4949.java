package codingtest.baekjoon.dfs_bfs.silver;

import java.io.*;
import java.util.*;

public class B4949 {
    static List<Character> charList = List.of('(', ')', '[', ']');
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = "";
        while (!(line = br.readLine()).equals(".")) {

            Stack<Character> stack = new Stack();

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if (!charList.contains(c)) continue;
                if(stack.isEmpty()) stack.add(c);
                else{
                    char peek = stack.peek();

                    if ((peek == '(' && c == ')') ||
                        (peek == '[' && c == ']')) {
                        stack.pop();
                    }else{
                        stack.add(c);
                    }
                }
            }
            if (stack.isEmpty()) {
                System.out.println("yes");
            }else{
                System.out.println("no");
            }

        }
    }
}
