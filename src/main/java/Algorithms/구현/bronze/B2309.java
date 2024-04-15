package Algorithms.구현.bronze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        List ret = new ArrayList<Integer>();

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - (arr[i] + arr[j]) == 100) {
                    for (int k = 0; k < 9; k++) {
                        if(k == i || k == j)continue;
                        ret.add(arr[k]);
                    }
                    Collections.sort(ret);
                    for (int l = 0; l < ret.size(); l++) {
                        System.out.println(ret.get(l));
                    }
                    return;
                }
            }
        }



    }
}
