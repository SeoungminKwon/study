package Algorithms.bruteforce.gold;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B12851 {

    static int dir[] =  {-1, 1, 2};
    public static void main(String[] args) {
        int n, k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int[] visited = new int[100003];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        visited[n] = 1;
        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int i = 0; i < 3; i++) {
                int nx = 0;
                if (i == 2) {
                    nx = x * dir[i];
                } else {
                    nx = x + dir[i];
                }
                if(nx < 0 || nx > 100_000) continue;
                if(visited[nx] != 0) continue;

                queue.add(nx);
                visited[nx] = visited[x] + 1;
            }
        }

        int cnt = count(n,k, visited);
        System.out.println(visited[k]-1);
        System.out.println(cnt);
    }

    static int count(int n, int k, int[] visited) {
        if(n == k)return 1;
        int cnt = 0;
        if (k == 0) {
            if(visited[k] == visited[k + 1] + 1) cnt++;
        } else if (k == 100_000) {
            if(visited[k] == visited[k-1] + 1)cnt++;
        } else {
            if (k % 2 == 0) {
                if(visited[k /2] + 1 == visited[k])cnt++;
            }
            if(visited[k + 1] + 1 == visited[k])cnt++;
            if(visited[k - 1] + 1 == visited[k])cnt++;
        }
        return cnt;
    }
}



