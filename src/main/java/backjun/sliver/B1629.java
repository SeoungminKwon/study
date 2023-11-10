package backjun.sliver;

import java.io.*;


public class B1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        long a = Long.parseLong(split[0]);
        long b = Long.parseLong(split[1]);
        long c = Long.parseLong(split[2]);

        System.out.println(d(a, b, c));
    }

    public static long d(long a, long b, long c){
        if(b == 0)return 1;
        if(b == 1)return a % c;
        long x = d(a, b/2, c);
        if(b % 2 == 0){
            return (x * x) % c;
        }else{
            return (((x * x) % c) * a) % c;
        }

    }
}


