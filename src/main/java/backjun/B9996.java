package backjun;

import java.util.Scanner;

public class B9996 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String buffer = sc.nextLine();
        String p = sc.nextLine();
        String[] split = p.split("\\*");
        split[1] = new StringBuffer(split[1]).reverse().toString();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            StringBuffer stb = new StringBuffer(str);
            String str2 = stb.reverse().toString();



        }
    }
}
