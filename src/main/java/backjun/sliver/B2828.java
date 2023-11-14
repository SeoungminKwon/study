package backjun.sliver;

import java.util.Scanner;

public class B2828{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        m--;
        int j = sc.nextInt();
        int left = 0;
        int right = left + m;

        int[] a = new int[23];
        for(int i = 0; i < j; i++){
            a[i] = sc.nextInt() -1;
        }
        int ret = 0;
        for(int i = 0; i < j; i++){
            if(left <= a[i] && right >= a[i])continue;
            if(left > a[i]){
                ret += Math.abs(left - a[i]);
                left = a[i];
                right = a[i] + m;
            }else if(right < a[i]){
                ret += Math.abs(a[i] - right);
                right = a[i];
                left = a[i] - m;
            }
        }
        System.out.println(ret);

    }
}
