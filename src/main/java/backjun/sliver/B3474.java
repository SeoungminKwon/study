package backjun.sliver;

import java.util.Scanner;

public class B3474 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1 ; i <= n; i++){
            int num2 = 0;
            int num5 = 0;
            int num = sc.nextInt();
            long beforeTime = System.currentTimeMillis();
            for (int j = 1; j <= num; j++) {
                if(j % 2 == 0){
                    num2 += go(j, 2);
                }
                if(j % 5 == 0){
                    num5 += go(j, 5);
                }
            }
            long afterTime = System.currentTimeMillis();
            long secDiffTime = (afterTime - beforeTime)/1000;
            System.out.println("시간차이(m) : " + secDiffTime);
            System.out.println(Math.min(num2, num5));
        }
    }

    static int go(int num, int twoFive){
        int ret = 0;
        while(true){
            if(num % twoFive != 0)break;
            num /= twoFive;
            ret++;
        }
        return ret;
    }
}
