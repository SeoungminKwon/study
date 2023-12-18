//package backjun.gold;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class B2589 {
//
//    static char[][] a;
//    static int[][] visited;
//    static List<Pair> lands = new ArrayList<Pair>();
//    static int[] dy = {-1, 0, 1, 0};
//    static int[] dx = {0, 1, 0, -1};
//    static int n;
//    static int m;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//
//        a = new char[n][m];
//        for (int i = 0; i < n; i++) {
//            String str = br.readLine();
//            for (int j = 0; j < str.length(); j++) {
//                a[i][j] = str.charAt(j);
//                if(a[i][j] == 'L') lands.add(new Pair(i, j));
//            }
//        }
//        int result = Integer.MIN_VALUE;
//        for (Pair land : lands) {
//            visited = new int[n][m];
//            visited[land.y][land.x] = 1;
//
//            bfs(land.y, land.x);
//            int ret = Integer.MIN_VALUE;
//            for (Pair p : lands) {
//                ret = Math.max(ret, visited[p.y][p.x]);
//            }
//            result = Math.max(result, ret);
//        }
//
//        System.out.println(result - 1);
//    }
//
//    static void bfs(int yy, int xx) {
//        Queue< Pair > q = new LinkedList<>();
//        q.add(new Pair(yy, xx));
//        while(!q.isEmpty()){
//            int y = q.peek().y;
//            int x = q.peek().x;
//            q.poll();
//            for (int i = 0; i < 4; i++) {
//                int ny = y + dy[i];
//                int nx = x + dx[i];
//                if(ny < 0 || nx < 0 || ny >= n || nx >= m)continue;
//                if(visited[ny][nx] != 0)continue;
//                if(a[ny][nx] == 'W')continue;
//                visited[ny][nx] = visited[y][x] + 1;
//                q.add(new Pair(ny, nx));
//            }
//        }
//    }
//}
//
////class Pair{
////    int y;
////    int x;
////
////    public Pair(int y, int x) {
////        this.y = y;
////        this.x = x;
////    }
////}
