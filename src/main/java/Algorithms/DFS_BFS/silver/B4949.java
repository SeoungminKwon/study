package Algorithms.DFS_BFS.silver;

import java.util.Scanner;
import java.util.Stack;

public class B4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        while (true) {
            String s = sc.nextLine();
            if(s.equals(".")) break;
            stack.clear();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(!(c == '(' || c == ')' || c == '[' || c == ']'))continue;

                if (stack.isEmpty() || c == '(' || c == '[') {
                    stack.push(c);
                }else{
                    Character peek = stack.peek();
                    if (peek == '(') {
                        if(c == ')')stack.pop();
                        else stack.push(c);
                    } else if (peek == '[') {
                        if (c == ']') {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                    } else {
                        stack.push(c);
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
