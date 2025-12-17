package codingtest.bfs_dfs.silver;

import java.util.*;
import java.io.*;

public class B9012 {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String buffer = sc.nextLine();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();

            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < input.length(); j++) {
                if (stack.empty()) {
                    stack.push(input.charAt(j));
                }else{
                    Character c = stack.peek();
                    if(c == '(' && input.charAt(j) == ')') stack.pop();
                    else{
                        stack.push(input.charAt(j));
                    }
                }
            }

            if (stack.empty()) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
