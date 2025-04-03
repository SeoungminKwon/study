package codingtest.baekjoon.dfs_bfs.gold;

import java.io.*;
import java.util.*;


public class B1068 {
    static int n;
    static int[] visited = new int[54];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<Integer>());
        }

        String[] inputs = br.readLine().split(" ");
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int subNode = i;
            int rootNode = Integer.parseInt(inputs[i]);

            List<Integer> subNodes = map.getOrDefault(rootNode, new ArrayList<Integer>());
            subNodes.add(subNode);
            map.put(rootNode, subNodes);
        }


        Queue<Node> q = new LinkedList<>();
        int removeNode = Integer.parseInt(br.readLine());
        if (!map.containsKey(0)) {
            System.out.println(0);
        }else{
            int cnt = 0;
            q.add(new Node(-1, 0, map.get(0)));
            visited[0] = 1;
            while (!q.isEmpty()) {
                Node node = q.poll();
                List<Integer> subNodes = node.getSubNode();

                for (int subNode : subNodes) {
                    if(removeNode == subNode) continue;
                    visited[subNode] = visited[node.now] + 1;
                    if(map.get(subNode) == null) {
                        cnt++;
                        continue;
                    }
                    q.add(new Node(node.now, subNode, map.get(subNode)));
                }
            }
            System.out.println(cnt);

        }







    }
    static class Node{
        int root;
        int now;
        List<Integer> subNodes;

        Node(int root, int now, List<Integer> subNodes) {
            this.root = root;
            this.now = now;
            this.subNodes = subNodes;
        }

        public List<Integer> getSubNode() {
            return this.subNodes;
        }
    }
}
