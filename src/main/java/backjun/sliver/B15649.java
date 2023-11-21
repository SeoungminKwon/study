package backjun.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B15649 {

    static int[] a;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        a = new int[m];
        visited = new boolean[n];

        dfs(n, m, 0);

    }

    static void dfs(int n, int m, int now) {
        if(now == m){
            for(int tmp : a){
                System.out.print(tmp + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                a[now] = i + 1;
                dfs(n, m, now +1);
                visited[i] = false;
            }
        }
    }


}

