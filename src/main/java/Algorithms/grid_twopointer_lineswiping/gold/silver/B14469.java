package Algorithms.grid_twopointer_lineswiping.gold.silver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class B14469 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            pairs.add(new Pair(a, b));
        }

        pairs.sort(Comparator.comparingInt(p -> p.first));

        int ret = 0;
        for (Pair pair : pairs) {
            int a = pair.first;
            int b = pair.second;
            if(a > ret){
                ret = a;
                ret += b;
            }
            else {
                ret += b;
            }
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
