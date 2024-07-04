package Algorithms.grid_twopointer_lineswiping.gold;

import java.util.ArrayList;
import java.util.Scanner;

public class B1644 {
    static int n;
    static boolean[] prime = new boolean[4000003];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true; // true - 소수x / false - 소수
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if(!prime[i])list.add(i);
        }

        int ret = 0;
        for (int i = 0; i < list.size(); i++) {
            int sum = 0;
            for (int j = i; j < list.size(); j++) {
                sum += list.get(j);
                if(sum > n) {
                    break;
                }
                if(sum == n){
                    ret++;
                    break;
                }
            }
        }

        System.out.println(ret);
    }
}
