package Algorithms.DFS_BFS.gold;

import java.util.ArrayList;
import java.util.Scanner;

public class B1068 {
    static int ret = 0;
    static ArrayList<Integer>[] node = new ArrayList[53];
    static int[] rNode = new int[53];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < 53; i++) {
            node[i] = new ArrayList<>();
        }



        int root = 0;
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if(tmp == -1){
                root = i;
                continue;
            }
            node[tmp].add(i);
            rNode[i] = tmp;
        }

        int remove = sc.nextInt();
        if(remove == root){
            System.out.println(0);
            System.exit(0);
        }
        int i = rNode[remove];
        node[i].remove((Integer)remove);

        dfs(root);
        System.out.println(ret);
    }
    static void dfs(int n) {
        ArrayList<Integer> arrayList = node[n];

        int check = 0;
        for (int i : arrayList) {
            check++;
            dfs(i);
        }
        if(check == 0)ret++;
    }
}
