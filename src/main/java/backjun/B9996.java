package backjun;

import java.util.Scanner;

public class B9996 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String p = sc.next();
        String[] sArr = p.split("\\*");

        String tmp1 = "", tmp2 = "";


        for(int i = 0 ; i < n; i++){
            String s = sc.next();
            if(sArr[0].length() > s.length() || sArr[1].length() > s.length()){
                System.out.println("NE");
                continue;
            }
            tmp1 = s.substring(0, sArr[0].length());
            tmp2 = s.substring(s.length() - sArr[1].length());

            if(tmp1.equals(sArr[0]) && tmp2.equals(sArr[1])){
                System.out.println("DA");
            }else{
                System.out.println("NE");
            }
        }


    }
}
