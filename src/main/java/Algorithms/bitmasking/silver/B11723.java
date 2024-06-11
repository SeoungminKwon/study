package Algorithms.bitmasking.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B11723 {
    static int n;
    static int ret = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int num = 0;
            if (!s.equals("all")  && !s.equals("empty")) {
                num = Integer.parseInt(st.nextToken());
                num--;
            }


            switch (s) {
                case "add" :
                    add(num);
                    break;
                case "remove" :
                    remove(num);
                    break;
                case "toggle" :
                    toggle(num);
                    break;
                case "all" :
                    all();
                    break;
                case "empty" :
                    empty();
                    break;
                case "check" :
                    check(num);
                    break;
            }
        }
        System.out.println(sb.toString());
    }

    static void add(int num) {
        ret |= (1 << num);
    }

    static void remove(int num) {
        ret &= ~(1 << num);
    }

    static void check(int num) {
        if((ret & (1 << num)) != 0) sb.append("1\n");
        else sb.append("0\n");
    }

    static void toggle(int num) {
        ret ^= (1 << num);
    }

    static void all() {
        ret = (1 << 20) -1;
    }

    static void empty() {
        ret = 0;
    }
}
