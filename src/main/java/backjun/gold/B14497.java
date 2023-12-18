//package backjun.gold;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class B14497 {
//    static int n;
//    static int m;
//    static char[][] a;
//    static int[][] visited;
//    static int[] dy = {-1, 0, 1, 0};
//    static int[] dx = {0, 1, 0, -1};
//
//    static List< Pair > change;
//    static boolean flag = false;
//
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//        a = new char[n][m];
//        Pair junan = new Pair(sc.nextInt() -1, sc.nextInt() -1);
//        Pair goal = new Pair(sc.nextInt() -1 , sc.nextInt() -1);
//
//        for (int i = 0; i < n; i++) {
//            String str = sc.next();
//            for (int j = 0; j < m; j++) {
//                a[i][j] = str.charAt(j);
//            }
//        }
//        int cnt = 0;
////        while (true) {
////            cnt++;
////            visited = new int[n][m];
////            change = new ArrayList<>();
////            dfs(junan.y, junan.x);
////            if(flag == true){
////                System.out.println(cnt);
////                break;
////            }
////            for(Pair p : change){
////                a[p.y][p.x] = 0;
////            }
////        }
//    }
//
//    static void dfs(int y, int x) {
//        visited[y][x] = 1;
//
//        for (int i = 0; i < 4; i++) {
//            int ny = y + dy[i];
//            int nx = x + dx[i];
//            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
//            if(visited[ny][nx] != 0)continue;
//            if (a[ny][nx] == '1') {
//                visited[ny][nx] = 2;
//                change.add(new Pair(ny, nx));
//                continue;
//            }
//            if(a[ny][nx] == '#'){
//                flag = true;
//                break;
//            }
//            if(flag == true)return;
//            dfs(ny, nx);
//        }
//    }
//}
////class Pair{
////    int y;
////    int x;
////
////    public Pair(int y, int x) {
////        this.y = y;
////        this.x = x;
////    }
////}
