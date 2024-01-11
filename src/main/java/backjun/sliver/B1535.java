package backjun.sliver;

import java.util.Scanner;

public class B1535 {
    static int n;
    static int[] dp, joy, stamina;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[103];
        joy = new int[23];
        stamina = new int[23];
        for (int i = 0; i < n; i++) {
            stamina[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            joy[i] = sc.nextInt();
        }

        for (int j = 0; j < n; j++) {
            for(int i = 100; i >= stamina[j]; i--){
                dp[i] = Math.max(dp[i], dp[i-stamina[j]] + joy[j]);
           }
        }


        System.out.println(dp[1]);
    }
}
