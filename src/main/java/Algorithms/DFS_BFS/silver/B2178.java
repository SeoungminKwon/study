package Algorithms.DFS_BFS.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2178 {
    static int n, m;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[] a[] = new int[103][103];
    static int[] visited[] = new int[103][103];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for(int j = 0; j < m; j++){
                a[i][j] = str.charAt(j) - '0';
            }
        }
        Queue< Pair > q = new LinkedList<>();

        q.add(new Pair(0,0));
        visited[0][0] = 1;
        while(q.size() != 0){


            Pair p  = q.poll();
            int y = p.y;
            int x = p.x;
            for(int i = 0 ; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m)continue;
                if(visited[ny][nx] != 0)continue;
                if(a[ny][nx] != 1)continue;
                q.add(new Pair(ny, nx));
                visited[ny][nx] = visited[p.y][p.x] + 1;
            }
        }
        System.out.println(visited[n-1][m-1]);
    }

}

class Pair{
    public int y;
    public int x;

    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

