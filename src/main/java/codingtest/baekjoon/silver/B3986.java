package codingtest.baekjoon.silver;

import java.util.Scanner;
import java.util.Stack;

public class B3986 {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String buffer = sc.nextLine();

        int ret = 0;
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String input = sc.nextLine();

            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);

                if (stack.size() == 0) {
                    stack.push(c);
                }else{
                    char peek = stack.peek();
                    if (c == peek) {
                        stack.pop();
                    }else{
                        stack.push(c);
                    }
                }
            }

            if (stack.size() == 0) {
                ret++;
            }
        }

        System.out.println(ret);
    }
}
