//package backjun.gold;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.lang.reflect.ParameterizedType;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class B4179 {
//
//    static char[][] a;
//    static int[][] visitedJ;
//    static int[][] visitedF;
//    static int[] dy = {-1, 0, 1, 0};
//    static int[] dx = {0, 1, 0, -1};
//    static int r;
//    static int c;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        r = Integer.parseInt(st.nextToken());
//        c = Integer.parseInt(st.nextToken());
//
//        a = new char[r][c];
//        visitedJ = new int[r][c];
//        visitedF = new int[r][c];
//        Pair jihun = null;
//        ArrayList< Pair > fireList = new ArrayList<>();
//        for (int i = 0; i < r; i++) {
//            String str = br.readLine();
//            for (int j = 0; j < c; j++) {
//                a[i][j] = str.charAt(j);
//                if (a[i][j] == 'J') jihun = new Pair(i, j);
//                if (a[i][j] == 'F') fireList.add(new Pair(i, j));
//                if(a[i][j] == '#'){
//                    visitedJ[i][j] = -1;
//                    visitedF[i][j] = -1;
//                }
//            }
//        }
//
//
//
//        bfsJ(jihun.y, jihun.x);
//        bfsF(fireList);
//
//
//        int result = Integer.MAX_VALUE;
//        for (int i = 0; i < r; i++) {
//            if ((a[i][0] != '#' && visitedJ[i][0] < visitedF[i][0]) || (a[i][0] != '#' && visitedF[i][0] == 0 && visitedJ[i][0] > 0)) {
//                result = Math.min(result, visitedJ[i][0]);
//
//            }
//
//            if ((a[i][c - 1] != '#' && visitedJ[i][c - 1] < visitedF[i][c - 1]) || (a[i][c - 1] != '#' && visitedF[i][c - 1] == 0 && visitedJ[i][c - 1] > 0)) {
//                result = Math.min(result, visitedJ[i][c - 1]);
//            }
//        }
//
//
//
//        for (int i = 0; i < c; i++) {
//            if ((a[0][i] != '#' && visitedJ[0][i] < visitedF[0][i]) || (a[0][i] != '#' && visitedF[0][i] == 0 && visitedJ[0][i] > 0)) {
//                result = Math.min(result, visitedJ[0][i]);
//            }
//
//
//            if ((a[r-1][i] != '#' && visitedJ[r-1][i] < visitedF[r-1][i]) || (a[r-1][i] != '#' && visitedF[r-1][i] == 0 && visitedJ[r-1][i] > 0)) {
//                result = Math.min(result, visitedJ[r - 1][i]);
//            }
//        }
//        if (result == Integer.MAX_VALUE || result == 0) {
//            System.out.println("IMPOSSIBLE");
//        } else {
//            System.out.println(result);
//        }
//
//    }
//
//    static void bfsJ(int yy, int xx) {
//        visitedJ[yy][xx] = 1;
//        Queue< Pair > q = new LinkedList< Pair >();
//        q.add(new Pair(yy, xx));
//
//
//        while (!q.isEmpty()) {
//            int y = q.peek().y;
//            int x = q.peek().x;
//            q.poll();
//            for (int i = 0; i < 4; i++) {
//                int ny = y + dy[i];
//                int nx = x + dx[i];
//                if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
//                if (visitedJ[ny][nx] != 0) continue;
//                if (a[ny][nx] == '#') continue;
//                visitedJ[ny][nx] = visitedJ[y][x] + 1;
//                q.add(new Pair(ny, nx));
//            }
//        }
//    }
//
//    static void bfsF(ArrayList< Pair > fireList) {
//        Queue< Pair > q = new LinkedList< Pair >();
//        for(Pair fire : fireList){
//            visitedF[fire.y][fire.x] = 1;
//            q.add(new Pair(fire.y, fire.x));
//        }
//
//        while (!q.isEmpty()) {
//            int y = q.peek().y;
//            int x = q.peek().x;
//            q.poll();
//            for (int i = 0; i < 4; i++) {
//                int ny = y + dy[i];
//                int nx = x + dx[i];
//                if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
//                if (visitedF[ny][nx] != 0) continue;
//                if (a[ny][nx] == '#') continue;
//                visitedF[ny][nx] = visitedF[y][x] + 1;
//                q.add(new Pair(ny, nx));
//            }
//        }
//    }
//
//}
//
////class Pair {
////    int y;
////    int x;
////
////    public Pair(int y, int x) {
////        this.y = y;
////        this.x = x;
////    }
////}
//
