package Algorithms.re.bitmasking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B17471 {
    static int n;
    static ArrayList<Integer>[] adj = new ArrayList[11];
    static int[] comp = new int[11];
    static int[] visited = new int[11];
    static int[] a = new int[11];
    static int ret = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < 11; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            int m = sc.nextInt();
            for (int j = 0; j < m; j++) {
                int temp = sc.nextInt();
                adj[i].add(temp);
                adj[temp].add(i);
                adj[temp].add(i);
            }
        }

        for (int i = 1; i < (1 << n) -1; i++) {
            Arrays.fill(comp, 0);
            Arrays.fill(visited, 0);
            int idx1 = -1, idx2 = -1;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    comp[j + 1] = 1;
                    idx1 = j + 1; //시작점
                } else {
                    idx2 = j + 1;
                }
            }

            Pair comp1 = dfs(idx1, 1);
            Pair comp2 = dfs(idx2, 0);

            if (comp1.cnt + comp2.cnt == n) {
                ret = Math.min((ret), Math.abs(comp1.sum - comp2.sum));
            }
            System.out.println(ret);
        }
    }

    static Pair dfs(int here, int value) {
        visited[here] = 1;
        Pair ret = new Pair(1, a[here]);

        for (int there : adj[here]) {
            if(comp[there] != value)continue;
            if(visited[there] != 0) continue;
            Pair temp = dfs(there, value);
            ret.cnt += temp.cnt;
            ret.sum += temp.sum;
        }
        return ret;
    }

    static class Pair{
        int cnt;
        int sum;

        public Pair(int cnt, int sum) {
            this.cnt = cnt;
            this.sum = sum;
        }
    }

}
