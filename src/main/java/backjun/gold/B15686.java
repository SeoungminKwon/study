//package backjun.gold;
//
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class B15686{
//
//    static int[][] a;
//    static boolean[] visited;
//    static ArrayList<Pair> homeList = new ArrayList<>();
//    static ArrayList< Pair > chickenList = new ArrayList<>();
//    static int result = Integer.MAX_VALUE;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//
//        a = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < n; j++) {
//                a[i][j] = Integer.parseInt(st.nextToken());
//                if(a[i][j] == 1) homeList.add(new Pair(i, j));
//                if(a[i][j] == 2) chickenList.add(new Pair(i, j));
//            }
//        }
//        visited = new boolean[chickenList.size()];
//        dfs(m, 0, 0);
//        System.out.println(result);
//
//    }
//
//    static void dfs(int m, int start, int now) {
//        if (now >= m) {
//
//           int total = 0;
//            for (int i = 0; i < homeList.size(); i++) {
//                int ret = Integer.MAX_VALUE;
//                for (int j = 0; j < chickenList.size(); j++) {
//                    if (visited[j] == true) {
//                        ret = Math.min(ret, Math.abs(homeList.get(i).y - chickenList.get(j).y) + Math.abs(homeList.get(i).x - chickenList.get(j).x));
//                    }
//                }
//                total += ret;
//            }
//            result = Math.min(total, result);
//        }
//
//        for (int i = start; i < chickenList.size(); i++) {
//            if(!visited[i]){
//                visited[i] = true;
//                dfs(m,start+1, now + 1);
//                visited[i] = false;
//            }
//        }
//    }
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