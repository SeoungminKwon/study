package codingtest.bfs_dfs.silver;

import java.util.*;
import java.io.*;

public class B2828 {
    static int n, m, j;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        j = sc.nextInt();
        Buket bk = new Buket(m);
        int cnt = 0;
        for (int i = 0; i < j; i++) {
            cnt += bk.move(sc.nextInt());
        }

        System.out.println(cnt);
    }

    static class Buket{
        int left;
        int right;

        Buket(int length) {
            this.left = 1;
            this.right = left + length - 1;
        }

        public int move(int now) {
            if(now >= left && now <= right) return 0;
            else if (now < left) {
                int temp = left - now;
                left -= temp;
                right -= temp;
                return temp;
            } else{
                int temp = now - right;
                right += temp;
                left += temp;
                return temp;
            }
        }


    }
}
