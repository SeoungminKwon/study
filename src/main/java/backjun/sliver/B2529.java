package backjun.sliver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class B2529 {

    static int[] visited = new int[10];
    static String _max = "";
    static String _min = "";
    static int k;

    static int cnt;
    static String[] eq;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        String buffer = sc.nextLine();
        eq = sc.nextLine().split(" ");

        for(int i = 0; i < k+1; i++) {
            _max += "0";
            _min += "9";
        }


        ArrayList< Integer > ret = new ArrayList<>();
        go(0, ret);

        System.out.println(_max);
        System.out.println(_min);

    }

    static void go(int now, ArrayList<Integer> ret){
        if(ret.size() == k+1){

            System.out.println("=================================");
            System.out.println(++cnt);
            for(int n : ret){
                System.out.print(n + " ");
            }
            System.out.println();

            result(ret);
            return;
        }

        for(int i = 0; i < 10; i++){
            if(visited[i] != 0) continue;
            ret.add(i);
            visited[i] = 1;
            if(now >= 1){
                if(calc(now, ret)){
                    go(now + 1, ret);
                }else{
                    ret.remove(ret.size() -1);
                    visited[i] = 0;
                }
            }else{
                go(now + 1, ret);
            }

        }
    }

    static void result(ArrayList<Integer> ret){
        String num = "";
        for (int i = 0; i < ret.size(); i++) {
            num += ret.get(i)+"";
        }

        int ret1 = _max.compareTo(num);
        int ret2 = _min.compareTo(num);

        if(ret1 < 0){
            _max = num;
        }
        if(ret2 > 0){
            _min = num;
        }

    }

    static boolean calc(int now , ArrayList<Integer> ret) {
        int prv = now -1;

        if(eq[prv].equals("<")){
            return ret.get(prv) < ret.get(now);
        }else{
            return ret.get(prv) > ret.get(now);
        }
    }


}
