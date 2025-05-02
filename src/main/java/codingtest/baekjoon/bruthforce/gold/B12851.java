package codingtest.baekjoon.bruthforce.gold;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B12851 {
    static final int MAX = 200_000;
    static int[] visited = new int[MAX + 4];
    static long[] cnt = new long[MAX + 4];
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        if (n == m) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        visited[n] = 1;
        cnt[n] = 1;
        q.add(n);

        while (!q.isEmpty()) {
            int now = q.poll();
            int[] directions = {now - 1, now + 1, now * 2};

            for (int next : directions) {
                if (next >= 0 && next <= MAX) {
                    if (visited[next] == 0) {
                        visited[next] = visited[now] + 1;
                        cnt[next] = cnt[now];
                        q.add(next);
                    }else if(visited[next] == visited[now] + 1){
                        cnt[next] += cnt[now];
                    }
                }
            }
        }

        System.out.println(visited[m] - 1);
        System.out.println(cnt[m]);




    }
}
