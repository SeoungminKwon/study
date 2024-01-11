package backjun.bronze;

import java.util.Scanner;

public class B2979 {
    public static void main(String[] args) {
        int[] cnt = new int[104];
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        for (int i = 0; i < 3; i++) {
            int start = sc.nextInt(); start--;
            int end = sc.nextInt(); end--;

            for (int j = start; j < end; j++) {
                cnt[j]++;
            }
        }
        int sum = 0;
        for (int i = 0; i < cnt.length; i++) {
            if(cnt[i] == 0)continue;
            if (cnt[i] == 1){
                sum += a;
            } else if (cnt[i] == 2) {
                sum += b * 2;
            } else if (cnt[i] == 3) {
                sum += c * 3;
            }
        }

        System.out.println(sum);

    }
}
