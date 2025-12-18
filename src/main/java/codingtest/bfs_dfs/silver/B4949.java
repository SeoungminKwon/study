package codingtest.bfs_dfs.silver;

import java.util.*;
import java.io.*;

public class B4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            String line = br.readLine();
            if(line.equals(".")) break;
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == '[' || c == ']' || c == '(' || c == ')') {

                    if (stack.empty()) {
                        stack.add(c);
                    }else{
                        char temp = stack.peek();
                        if (temp == '[') {
                            if (c == ']') {
                                stack.pop();
                            }else{
                                stack.add(c);
                            }
                        } else if (temp == '(') {
                            if (c == ')') {
                                stack.pop();
                            }else{
                                stack.add(c);
                            }
                        }
                    }
                }
            }

            if (stack.empty()) {
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}
