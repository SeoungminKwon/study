package backjun.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B16235 {
    static int n, m, k;
    static int[][] land = new int[104][104];
    static int[][] nut = new int[104][104];

    static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    static Deque< Tree > treeList = new LinkedList<>();
    static List< Tree > deadTreeList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //n - n*n 땅, m - 나무의 갯수, k - 몇년
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                nut[i][j] = 5;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); x--;
            int y = Integer.parseInt(st.nextToken()); y--;
            int age = Integer.parseInt(st.nextToken());
            Tree tree = new Tree(y, x, age);
            treeList.add(tree);
        }

        if (treeList.size() >= 2) {
            treeList.stream().sorted(new Comparator< Tree >() {
                @Override
                public int compare(Tree o1, Tree o2) {
                    return o1.age - o2.age;
                }
            });
        }

        while (k-- != 0) {
            springAndSummer();
            fall();
            winter();
        }

        System.out.println(treeList.size());
    }

    static void springAndSummer() {

        Deque< Tree > newDt = new LinkedList<>();

        for (Tree t : treeList) {
            if((nut[t.y][t.x] - t.age) < 0){
                deadTreeList.add(t);
            }else{
                nut[t.y][t.x] -= t.age;
                newDt.add(t);
            }
        }

        for (Tree t : treeList) {
            t.age++;
        }

        for (Tree t : deadTreeList) {
            nut[t.y][t.x] += t.age / 2;
        }

        treeList = newDt;
        deadTreeList.clear();
    }

    static void fall() {
        List< Tree > addTreeList = new ArrayList<>();
        for (Tree t : treeList) {
            if(t.age % 5 != 0)continue;
            for (int i = 0; i < 8; i++) {
                int ny = t.y + dy[i];
                int nx = t.x + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= n)continue;
                addTreeList.add(new Tree(ny, nx, 1));
            }
        }

        for (Tree t : addTreeList) {
            treeList.addFirst(t);
        }
    }

    static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nut[i][j] += land[i][j];
            }
        }

    }

    static class Tree{
        int y;
        int x;
        int age;

        public Tree(int y, int x, int age) {
            this.y = y;
            this.x = x;
            this.age = age;
        }
    }
}
