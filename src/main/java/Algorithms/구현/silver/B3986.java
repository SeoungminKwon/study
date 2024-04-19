package Algorithms.구현.silver;

import java.util.Scanner;
import java.util.Stack;

public class B3986 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int ret= 0;

        int n = sc.nextInt();
        String buffer = sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(c);
                }else {
                    if (stack.peek() == c) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }

            if (stack.isEmpty()) {
                ret++;
            }
        }
        System.out.println(ret);
    }
}
