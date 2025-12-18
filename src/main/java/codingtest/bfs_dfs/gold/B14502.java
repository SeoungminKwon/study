package codingtest.bfs_dfs.gold;

import java.util.*;
import java.io.*;

public class B14502 {
    static int n, m;
    static int[][] arr = new int[10][10];
    static int[][] visited = new int[10][10];
    static List<Pair> wallList = new ArrayList<>();
    static List<Pair> virusList = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 0) wallList.add(new Pair(i, j));
                else if(num == 2) virusList.add(new Pair(i, j));
                arr[i][j] = num;
            }
        }

        // 벽 세우기
        List<Integer> createList = new ArrayList<>();
        createWall(-1, createList);

        System.out.println(result);
    }

    static void createWall(int now, List<Integer> createList) {

        if (createList.size() == 3) {

            int ret = 0;

            // 배열 복사
            int[][] copyArr = new int[10][10];
            for (int i = 0; i < n; i++) {
                System.arraycopy(arr[i], 0, copyArr[i], 0, m);
            }

            Pair wall1 = wallList.get(createList.get(0));
            Pair wall2 = wallList.get(createList.get(1));
            Pair wall3 = wallList.get(createList.get(2));

            copyArr[wall1.y][wall1.x] = 1;
            copyArr[wall2.y][wall2.x] = 1;
            copyArr[wall3.y][wall3.x] = 1;

            // dfs
            visited = new int[10][10];
            for (Pair virus : virusList) {
                dfs(virus.y, virus.x, copyArr);
            }

            // 안전 구역 계산
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(copyArr[i][j] != 0) continue;
                    if(visited[i][j] != 0) continue;
                    ret++;
                }
            }

            result = Math.max(result, ret);
            return;
        }

        for (int i = now + 1; i < wallList.size(); i++) {
            createList.add(i);
            createWall(i, createList);
            createList.remove(createList.size() - 1);
        }

    }

    static void dfs(int y, int x, int[][] copy) {
        visited[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if(visited[ny][nx] != 0) continue;
            if(copy[ny][nx] != 0)  continue;

            dfs(ny, nx, copy);
        }
    }

    static class Pair{
        int y;
        int x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
