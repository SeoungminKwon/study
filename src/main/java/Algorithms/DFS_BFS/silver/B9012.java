package Algorithms.DFS_BFS.silver;

import java.util.Scanner;
import java.util.Stack;

public class B9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            stack.clear();

            for (int j = 0; j < s.length(); j++) {
                if (stack.isEmpty()) {
                    stack.push(s.charAt(j));
                }else{
                    if (stack.peek() == '(' && s.charAt(j) == ')') {
                        stack.pop();
                    }else stack.push(s.charAt(j));
                }
            }
            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
