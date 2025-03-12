package codingtest.baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class B1940 {
    static int n, m;
    static int[] arr = new int[15003];
    public static void main(String[] args) {
        Arrays.fill(arr, Integer.MAX_VALUE);
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0, right = n - 1;
        int ret = 0;
        Arrays.sort(arr);
        while (left < right) {
            int temp = arr[left] + arr[right];
            if (temp == m) {
                ret++;
                left++;
                right--;
            }else{
                if (temp < m) {
                    left++;
                }else{
                    right--;
                }
            }
        }

        System.out.println(ret);

    }
}
