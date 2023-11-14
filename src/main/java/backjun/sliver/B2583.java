package backjun.sliver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B2583 {

    static int[][] a;
    static int[][] visited;
    static int[] dy= {-1, 0, 1, 0};
    static int[] dx= {0, 1, 0, -1};
    static int n, m, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map< Integer, Integer > map = new HashMap<>();
        m = sc.nextInt(); n = sc.nextInt(); k = sc.nextInt();
        a = new int[m][n];
        visited = new int[m][n];

        for(int i = 0; i < k; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for(int j = y1; j < y2; j++){
                for(int t = x1; t < x2; t++){
                    a[j][t] = 1;

                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(a[i][j] == 1)continue;
                if(visited[i][j] != 0)continue;
                cnt++;
                dfs(i, j, cnt);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (visited[i][j] == 0)continue;
                map.put(visited[i][j], map.getOrDefault(visited[i][j], 0) + 1);
            }
        }
        Object[] array = map.values().toArray();
        Arrays.sort(array);
        System.out.println(cnt);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }


    }

    public static void dfs(int y, int x, int cnt){
        visited[y][x] = cnt;

        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= m || nx >= n)continue;
            if(a[ny][nx] == 1)continue;
            if(visited[ny][nx] != 0)continue;
            dfs(ny, nx, cnt);
        }
    }
}

