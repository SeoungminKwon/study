package Algorithms.구현.bronze;

import java.util.Scanner;

public class B2979 {
    public static void main(String[] args) {
        int[] time = new int[100];
        int[] fee = new int[3];
        int ret = 0;

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            fee[i] = sc.nextInt();
        }

        for (int i = 0; i < 3; i++) {
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            for (int j = t1 - 1; j < t2 - 1; j++) {
                time[j]++;
            }
        }

        for (int i = 0; i < 100; i++) {
            if (time[i] == 1) {
                ret += fee[0];
            } else if (time[i] == 2) {
                ret += fee[1] * 2;
            } else if (time[i] == 3) {
                ret += fee[2] * 3;
            }else continue;
        }
        System.out.println(ret);
    }
}
