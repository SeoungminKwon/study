package Algorithms.bitmasking.gold;

import java.util.Scanner;

public class B1062 {

    static int n, m;
    static int[] words = new int[51];
    static String s;

    static int count(int mask) {
        int cnt = 0;
        for (int word : words) {
            if (word != 0 && (word & mask) == word) cnt++;
        }
        return cnt;
    }

    static int go(int index, int k, int mask) {
        if (k < 0) return 0;
        if (index == 26) return count(mask);

        int ret = go(index + 1, k - 1, mask | (1 << index));
        if (index != 'a' - 'a' && index != 'n' - 'a' && index != 't' - 'a'
                    && index != 'i' - 'a' && index != 'c' - 'a') {
            ret = Math.max(ret, go(index + 1, k, mask));
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        for (int i = 0; i < n; i++) {
            s = sc.nextLine();
            for (char c : s.toCharArray()) {
                words[i] |= (1 << (c - 'a'));
            }
        }

        System.out.println(go(0, m, 0));
    }
}
