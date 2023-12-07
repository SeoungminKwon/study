package backjun.gold;

import java.math.BigInteger;
import java.util.Scanner;

public class B1285 {
    static int n;
    static char[][] charArr = new char[23][23];

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String buffer = sc.nextLine();

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                charArr[i][j] = s.charAt(j);
            }
        }

        go(0);

    }

    static void go(int now){
        if(now == n * n){
            result = Math.max(result, checkBack());
            return;
        }
    }

    static int checkBack() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(charArr[i][j] == 'T')cnt++;
            }
        }

        return cnt;
    }

}
