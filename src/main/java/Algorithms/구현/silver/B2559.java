package Algorithms.구현.silver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B2559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();

        int tmp = sc.nextInt();
        arr.add(tmp);
        sum.add(tmp);
        for (int i = 1; i < n; i++) {
            int num = sc.nextInt();
            arr.add(num);
            sum.add(sum.get(i - 1) + num);
        }

        int max = sum.get(k-1);
        for (int i = k; i < sum.size(); i++) {
            max = Math.max(max, sum.get(i) - sum.get(i - k));
        }
        System.out.println(max);
    }
}
