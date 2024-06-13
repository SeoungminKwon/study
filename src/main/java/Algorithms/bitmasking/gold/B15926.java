package Algorithms.bitmasking.gold;

import java.util.Scanner;
import java.util.Stack;


// 반례
// 12 (()(()()(()

public class B15926 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        int[] d = new int[200001];
        int ret = 0, cnt = 0;
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else if (!stk.isEmpty()) {
                d[i] = d[stk.peek()] = 1;
                stk.pop();
            }
        }

        for (int i = 0; i < n; i++) {
            if (d[i] == 1) {
                cnt++;
                ret = Math.max(ret, cnt);
            } else {
                cnt = 0;
            }
        }

        System.out.println(ret);
    }
}
