package Algorithms.DFS_BFS.silver;

import java.util.Scanner;

public class B1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long cnt = 0;
        int ret = 0;
        while (true) {
            cnt++;
            String string = Long.toString(cnt);
            boolean contains = string.contains("666");
            if (contains) {
                ret++;
                if (ret == n) {
                    System.out.println(cnt);
                    break;
                }
            }
        }
    }
}
