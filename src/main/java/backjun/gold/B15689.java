//package backjun.gold;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class B15689 {
//    static int n, m;
//
//    static int[][] a = new int[10][10];
//    static int[][] cpyA = new int[10][10];
//    static List< Yx > list = new ArrayList<>();
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                a[i][j] = sc.nextInt();
//                if(a[i][j] >= 1 && a[i][j] <= 5) list.add(new Yx(i, j));
//            }
//        }
//
//
//        go(1);
//
//
//
//    }
//
//    static void go(int now, ArrayList<Integer> dirs) {
//        if (now == list.size()) {
//            for (int i = 0; i < list.size(); i++) {
//                solve(list.get(i), dirs.get(i));
//            }
//            solve(dirs);
//        }
//
//        for (int i = 0; i < 4; i++) {
//            Integer ii = (Integer) i;
//            dirs.add(ii);
//            go(now + 1, dirs);
//            dirs.remove(ii);
//        }
//    }
//
//    static void solve(Yx pair, int dir) {
//
//       if (a[pair.y][pair.x] == 1){
//           switch (dir) {
//               case 0:lookLeft(pair);
//               case 1:lookTop(pair);
//               case 2:lookRight(pair);
//               default: lookDown(pair);
//           }
//       }else if(a[pair.y][pair.x] == 2){
//           switch (dir) {
//               case 0:lookLeft(pair); lookRight(pair);
//               case 1:lookTop(pair); lookDown(pair);
//               case 2:lookLeft(pair); lookRight(pair);
//               default: lookTop(pair); lookDown(pair);
//           }
//       }else if(a[pair.y][pair.x] == 3){
//           switch (dir) {
//               case 0:lookLeft(pair); lookRight(pair);
//               case 1:lookTop(pair); lookDown(pair);
//               case 2:lookLeft(pair); lookRight(pair);
//               default: lookTop(pair); lookDown(pair);
//           }
//       }
//    }
//
//    static void lookLeft(Yx pair) {
//        for(int i = pair.x; i>= 0; i--){
//            cpyA[pair.y][i] = -1;
//        }
//    }
//    static void lookRight(Yx pair) {
//        for(int i = pair.x; i < m; i++){
//            cpyA[pair.y][i] = -1;
//        }
//    }
//    static void lookTop(Yx pair) {
//        for(int i = pair.y; i < n; i++){
//            cpyA[i][pair.x] = -1;
//        }
//    }
//    static void lookDown(Yx pair) {
//        for (int i = pair.y; i >= 0; i--) {
//            cpyA[i][pair.x] = -1;
//        }
//    }
//
//
//}
//
//class Yx{
//    int y;
//    int x;
//
//    public Yx(int y, int x) {
//        this.y = y;
//        this.x = x;
//    }
//}
