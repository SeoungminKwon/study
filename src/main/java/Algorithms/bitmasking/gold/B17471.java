package Algorithms.bitmasking.gold;

import java.util.*;

public class B17471 {
    static final int INF = 987654321;
    static int n, a[] = new int[11], m, temp, ret = INF, comp[] = new int[11], visited[] = new int[11];
    static ArrayList<Integer>[] adj = new ArrayList[11];

    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static Pair dfs(int here, int value) {
        visited[here] = 1;
        Pair ret = new Pair(1, a[here]);
        for (int there : adj[here]) {
            if (comp[there] != value) continue;
            if (visited[there] != 0) continue;
            Pair temp = dfs(there, value);
            ret.first += temp.first;
            ret.second += temp.second;
        }
        return ret;
    }

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
            m = sc.nextInt();
            for (int j = 0; j < m; j++) {
                temp = sc.nextInt();
                adj[i].add(temp);
                adj[temp].add(i);
            }
        }

        for (int i = 1; i < (1 << n) - 1; i++) {
            Arrays.fill(comp, 0);
            Arrays.fill(visited, 0);
            int idx1 = -1, idx2 = -1;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    comp[j + 1] = 1;
                    idx1 = j + 1;
                } else {
                    idx2 = j + 1;
                }
            }

            Pair comp1 = dfs(idx1, 1);
            Pair comp2 = dfs(idx2, 0);

            if (comp1.first + comp2.first == n) {
                ret = Math.min(ret, Math.abs(comp1.second - comp2.second));
            }
        }

        System.out.println(ret == INF ? -1 : ret);
    }
}
