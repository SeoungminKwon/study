package backjun.bronze;

import java.util.*;

public class B2309 {
    static int[] a = new int[9];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            a[i] = sc.nextInt();
        }


        Arrays.sort(a);
        go(-1, new ArrayList<>());
    }


    static void go(int now, List< Integer > ret) {
        if (ret.size() == 7) {
            int sum = 0;
            for (int i : ret) {
                sum += i;
            }

            if (sum == 100) {
                for (int i : ret) {
                    System.out.println(i);
                }
                System.exit(0);
            }
        }

        for (int i = now + 1; i < 9; i++) {
            ret.add((Integer) a[i]);
            go(i, ret);
            ret.remove((Integer) a[i]);
        }
    }
}
