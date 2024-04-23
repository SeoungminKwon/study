package Algorithms.DFS_BFS.silver;

import java.util.Scanner;

public class B2828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        Bucket bucket = new Bucket(--m);
        int ret = 0;

        for (int i = 0; i < k; i++) {
            int tmp = sc.nextInt();
            tmp--;
            ret += bucket.move(tmp);
        }
        System.out.println(ret);
    }

    static class Bucket{
        int l;
        int r;
        int w;

        public Bucket(int w) {
            this.l = 0;
            this.r = 0 + w;
            this.w = w;
        }

        public int move(int m) {
            if (m < l) {
                int cnt = l - m;
                l = m;
                r = l + w;
                return cnt;
            } else if (m > r) {
                int cnt = m - r;
                r = m;
                l = r - w;
                return cnt;
            }else return 0;
        }
    }
}
