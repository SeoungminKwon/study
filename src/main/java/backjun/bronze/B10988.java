package backjun.bronze;

import java.util.Collections;
import java.util.Scanner;

public class B10988 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sb.append(s);
        sb.reverse();
        if (s.equals(sb.toString())) {
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
