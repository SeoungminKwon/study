package backjun;

import java.util.Scanner;

public class B2559 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sumArr = new int[n];
        int a = sc.nextInt();


        for(int i = 1 ; i <= n; i++){
            int temp = sc.nextInt();
            sumArr[i] = sumArr[i -1] + temp;
        }
        int max = -987654321;
        for(int i = a; i <= n; i ++){
            max = Math.max(max, sumArr[i] - sumArr[i -a]);
        }
        System.out.println(max);
    }
}
