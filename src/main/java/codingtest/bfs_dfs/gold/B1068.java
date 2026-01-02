package codingtest.bfs_dfs.gold;

import java.util.*;
import java.io.*;

public class B1068 {
    static int n;
    static List<Integer> rootList = new ArrayList<>();
    static Map<Integer, List<Integer>> nodeMap = new HashMap<>();
    static int[] visited = new int[53];
    static int ret;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();


        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if(num == -1) rootList.add(i);
            else{
                // i -> 현재 node idx
                // num -> 상위 노드
                List<Integer> list = nodeMap.getOrDefault(num, new ArrayList<Integer>());
                list.add(i);
                nodeMap.put(num, list);
            }
        }

        int deleteNode = sc.nextInt();
        visited[deleteNode] = 1;

        for (int rootNode : rootList) {
            if(visited[rootNode] != 0) continue;
            if(nodeMap.get(rootNode) == null){
                ret++;
                continue;
            }
            bfs(rootNode);
        }

        System.out.println(ret);
    }

    static void bfs(int now) {
        visited[now] = 1;

        List<Integer> list = nodeMap.get(now);

        if (list == null) {
            ret++;
            return;
        }


        int childCnt = 0;
        for (int node : list) {
            if(visited[node] != 0) continue;
            childCnt++;
            bfs(node);
        }

        if (childCnt == 0) {
            ret++;
        }
    }
}
