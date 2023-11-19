package backjun.sliver;

import java.util.ArrayList;
import java.util.Scanner;

public class B1325 {
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ArrayList< Integer >[] arrayLists = new ArrayList[10003];
        for (int i = 0; i < 10000; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arrayLists[b].add(a);
        }


    }
}
