package codingtest.baekjoon.dfs_bfs.silver;

import java.util.*;
import java.io.*;

public class B1325 {
    static int n, m;
    static int ret = Integer.MIN_VALUE;
    static List<Integer> retList = new ArrayList<>();
    static List<List<Integer>> computers = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            computers.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int input1 = Integer.parseInt(st.nextToken());
            int input2 = Integer.parseInt(st.nextToken());
            computers.get(input2).add(input1);
        }

        for (int i = 1; i <= n; i++) {
            int[] visited = new int[10004];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = 1;

            while (!queue.isEmpty()) {
                 int node = queue.poll();

                List<Integer> computerList = computers.get(node);
                for (int computer : computerList) {
                    if(visited[computer] != 0) continue;
                    visited[computer] = visited[node] + 1;
                    queue.add(computer);
                }
            }
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if(visited[j] != 0) cnt++;
            }

            if (cnt == ret) {
                retList.add(i);
            }else if(cnt > ret){
                retList = new ArrayList<>();
                retList.add(i);
            }
            ret = Math.max(ret, cnt);
        };

        retList.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int num : retList) {
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString().trim());

    }
}
