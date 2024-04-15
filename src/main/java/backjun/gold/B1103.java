//package backjun.gold;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//public class B1103 {
//    static int n, m;
//    static char[][] a = new char[55][55];
//    static int[][] visited = new int[55][55];
//    static int[][] dp = new int[55][55];
//
//    static int[] dy = {-1, 0, 1, 0};
//    static int[] dx = {0, 1, 0, -1};
//    static boolean flag = true;
//    public static void main(String[] args) throws IOException {
//
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//        String buffer = sc.nextLine();
//
//        for (int i = 0; i < n; i++) {
//            String s = sc.nextLine();
//            for (int j = 0; j < m; j++) {
//                a[i][j] = s.charAt(j);
//            }
//        }
//
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                dp[i][j] = Integer.MIN_VALUE;
//            }
//        }
//        dp[0][0] = 1;
//
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if(a[i][j] == 'H')continue;
//
//            }
//        }
//
//        int ret = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                ret = Math.max(ret, dp[i][j]);
//            }
//        }
//
//        System.out.println(ret);
//
//    }
//
//    static boolean check(int y, int x){
//        if(y < 0 || x < 0 || y >= n || x >= m) return false;
//        if(a[y][x] == 'H') return false;
//
//    }
//
//
//}
