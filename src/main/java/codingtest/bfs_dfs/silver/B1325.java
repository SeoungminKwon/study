package codingtest.bfs_dfs.silver;

import java.util.*;
import java.io.*;

public class B1325 {
    static int n, m;
    static List<Integer>[] adj;
    static int[] dp;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        dp = new int[n + 1];
        visited = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[b].add(a);
        }

        int mx = 0;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(visited, 0);
            dp[i] = dfs(i);
            if(dp[i] > mx) mx = dp[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dp[i] == mx) {
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb.toString());


    }

    static int dfs(int here) {
        visited[here] = 1;
        int ret = 1;
        for (int there : adj[here]) {
            if(visited[there] == 1) continue;
            ret += dfs(there);
        }
        return ret;
    }
}
