package backjun.sliver;

import java.util.Scanner;

public class B1094 {
    public static void main(String[] args) {

        System.out.println(Integer.toString(23, 2));

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < 7; i++) {
            if(( n & (1 << i) ) != 0){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
