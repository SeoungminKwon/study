package Algorithms.구현.silver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B1940 {
    public static void main(String[] args) {
        int ret = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> al = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            al.add(sc.nextInt());
        }
        Collections.sort(al);

        int l = 0;
        int r = al.size() -1;

        while (l < r) {
            if (al.get(l) + al.get(r) > m) {
                r--;
            } else if (al.get(l) + al.get(r) == m) {
                ret++;
                l++;
                r--;
            } else if (al.get(l) + al.get(r) < m) {
                l++;
            }
        }

        System.out.println(ret);
    }
}
