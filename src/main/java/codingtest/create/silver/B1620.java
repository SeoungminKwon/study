package codingtest.create.silver;

import java.util.*;
import java.io.*;

public class B1620 {

    static long a,b,c;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        long result = solve(a, b);
        System.out.println(result);


    }

    static long solve(long aa, long bb) {

        if (bb == 1) {
//            System.out.println("bb = 1 ret : " + aa % c);
            return aa % c;
        }

        if (bb% 2 == 0) {
            long ret = solve(aa, bb%2);
//            System.out.println("bb = " + bb + " ret : " + ((ret % c) * (ret%c)) % c);
            return ((ret % c) * (ret%c)) % c;
        }else{
            long ret = solve(aa, bb%2);
            long result =  ((ret % c) * (ret%c)) % c;
//            System.out.println("bb = " + bb + " ret : " + result);
            return (result * aa) % c;
        }
    }
}
