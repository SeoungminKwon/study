package Algorithms.구현.bronze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int[] ret = new int[7];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - (arr[i] + arr[j]) == 100) {
                    int idx = 0;
                    for (int k = 0; k < 9; k++) {
                        if(k == i || k == j)continue;
                        ret[idx++] = arr[k];
                    }
                }
            }
        }
        Arrays.sort(ret);
        for (int i = 0; i < 7; i++) {
            System.out.println(ret[i]);
        }

    }
}
