package Algorithms.DFS_BFS.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1325 {
    static int n, m;
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static int cntArr[];
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[10003];
        cntArr = new int[10003];
        arr = new ArrayList[10003];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[--a].add(--b);
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[10003];
            dfs(i);
        }

        for (int i = 0; i < n; i++) {
            if(max < cntArr[i]) max = cntArr[i];
        }

        for (int i = 0; i < n; i++) {
            if (max == cntArr[i]) {
                System.out.println(i+1 + " ");
            }
        }

    }

    static void dfs(int i) {
        visited[i] = true;
        for (int node : arr[i]) {
            if(visited[node])continue;
            cntArr[i]++;
            dfs(node);
        }
    }
}
