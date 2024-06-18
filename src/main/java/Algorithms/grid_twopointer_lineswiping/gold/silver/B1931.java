package Algorithms.grid_twopointer_lineswiping.gold.silver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class B1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            pairs.add(new Pair(a, b));
        }

        pairs.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.second == o2.second) {
                    return o1.first - o2.first;
                }
                return o1.second - o2.second;
            }
        });

        int ret = 0;
        int tmp = 0;
        for (Pair pair : pairs) {
            int first = pair.first;
            int second = pair.second;
            if(tmp > first) continue;
            tmp = second;
            ret++;
        }
        System.out.println(ret);
    }
    static class Pair{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
