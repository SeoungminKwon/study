package Algorithms.bitmasking.platinum;

import java.util.Scanner;
import java.util.Stack;

public class B3015 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long ret = 0;
        long temp;
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            temp = scanner.nextLong();
            int cnt = 1;
            while (!stack.isEmpty() && stack.peek().first <= temp) {
                ret += stack.peek().second;
                if (stack.peek().first == temp) {
                    cnt = (int) (stack.peek().second + 1);
                } else {
                    cnt = 1;
                }
                stack.pop();
            }
            if (!stack.isEmpty()) ret++;
            stack.push(new Pair(temp, cnt));
        }

        System.out.println(ret);
    }

    static class Pair {
        long first;
        long second;

        Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }
}
