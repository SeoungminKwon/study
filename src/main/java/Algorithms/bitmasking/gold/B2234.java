package Algorithms.bitmasking.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2234 {
    static int n, m;
    static int[][] arr = new int[53][53];
    static int[][] visited = new int[53][53];
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};
    static int roomSize = 0;
    static int noChangeRoomSize = Integer.MIN_VALUE;
    static int ret = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int room = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j] != 0)continue;
                room++;
                roomSize = 0;
                dfs(i, j);
                noChangeRoomSize = Math.max(noChangeRoomSize, roomSize);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int[] ints : visited) {
                        Arrays.fill(ints, 0);
                    }
                    if((arr[i][j] & (1 << k)) == 0) continue;
                    roomSize = 0;
                    arr[i][j] = arr[i][j] & ~(1 << k);
                    dfs(i, j);
                    arr[i][j] = arr[i][j] | (1 << k);
                    ret = Math.max(ret, roomSize);
                }
            }
        }
        System.out.println(room);
        System.out.println(noChangeRoomSize +1);
        System.out.println(ret +1);
    }

    static void  dfs(int y, int x) {
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m)continue;
            if((arr[y][x] & (1 << i)) != 0)continue;
            if(visited[ny][nx] != 0)continue;
            roomSize++;
            dfs(ny, nx);
        }
    }
}
