package codingtest.baekjoon.dfs_bfs.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2828 {
    static int n, m, j;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        j = Integer.parseInt(br.readLine());
        int ret = 0;
        Box box = new Box(0, m - 1);


        for (int i = 0; i < j; i++) {
            int temp = Integer.parseInt(br.readLine()); temp--;
            ret += box.move(temp);
        }

        System.out.println(ret);
    }

    static class Box{
        int left;
        int right;

        Box(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int move(int now) {
            if (left <= now && right >= now) {
                return 0;
            }else{
                int temp = 0;
                if (now > right) {
                    temp = now - right;
                    right += temp;
                    left += temp;
                } else if (now < left) {
                    temp = left - now;
                    left -= temp;
                    right -= temp;
                }
                return temp;
            }
        }
    }
}
