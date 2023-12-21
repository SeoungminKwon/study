package backjun.sliver;

import java.util.Scanner;

public class B1912 {
    static int ret = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            sum += tmp;
            ret = Math.max(ret, sum);
            if(sum < 0)sum = 0;
        }
        if(sum != 0){
            ret = Math.max(ret, sum);
        }
        System.out.println(ret);

    }
}
