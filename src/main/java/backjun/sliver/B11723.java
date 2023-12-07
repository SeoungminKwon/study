package backjun.sliver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B11723 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());

        int ret = 0;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            int num = 0;
            if(st.hasMoreTokens()){
                num = Integer.parseInt(st.nextToken());
                num--;
            }



            if(operation.equals("add")){
                ret = add(num, ret);
            }else if(operation.equals("remove")){
                ret = remove(num, ret);
            }else if(operation.equals("check")){
                check(num, ret);
            }else if(operation.equals("toggle")){
                ret = toggle(num, ret);
            }else if(operation.equals("all")){
                ret = all(num);
            }else if(operation.equals("empty")){
                ret = 0;
            }

        }
        System.out.println(sb.toString());
    }

    static int add(int x, int n){
        n |= (1 << x);
        return n;
    }

    static int remove(int x, int n){
        n &= ~(1 << x);
        return n;
    }

    static void check(int x, int n) {
        if ((n &= (1 << x)) != 0) {
            sb.append("1\n");

        }else{
            sb.append("0\n");
        }
    }

    static int toggle(int x, int n) {
        return n ^= (1 << x);
    }

    static int all(int x) {
        return (1 << 20) -1;
    }
}
