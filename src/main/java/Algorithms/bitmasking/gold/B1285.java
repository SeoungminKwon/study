package Algorithms.bitmasking.gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1285 {

    static int n, ret = Integer.MAX_VALUE;
    static int[] a = new int[44];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            int value = 1;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'T') {
                    a[i] |= value;
                }
                value *= 2;
            }
        }

        go(1);
        System.out.println(ret);

    }

    static void go(int here) {
        if (here == n + 1) {
            int sum = 0;
            for (int i = 1; i <= (1 << (n - 1)); i *= 2) {
                int cnt = 0;
                for (int j = 1; j <= n; j++) {
                    if ((a[j] & i) != 0) {
                        cnt++;
                    }
                }
                sum += Math.min(cnt, n - cnt);
            }
            ret = Math.min(ret, sum);
            return;
        }

        go(here + 1);
        a[here] = ~a[here] & ((1 << n) - 1);
        go(here + 1);


    }
}
