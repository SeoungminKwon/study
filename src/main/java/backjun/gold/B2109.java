//package backjun.gold;
//
//import java.util.*;
//
//public class B2109 {
//
//    static int[] arr = new int[10004];
//
//    static List< Pair > pairList = new ArrayList<>();
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            pairList.add(new Pair(sc.nextInt(), sc.nextInt()));
//        }
//
//        Collections.sort(pairList, new Comparator< Pair >() {
//            @Override
//            public int compare(Pair o1, Pair o2) {
//                if(o1.pay == o2.pay){
//                    return o1.day - o2.day;
//                }
//                return o1.pay - o2.pay;
//            }
//        });
//
//        int ret = 0;
//        for (int i = 0; i < n; i++) {
//
//        }
//    }
//}
//
////class Pair{
////    int pay;
////    int day;
////
////    public Pair(int pay, int day) {
////        this.pay = pay;
////        this.day = day;
////    }
////}
