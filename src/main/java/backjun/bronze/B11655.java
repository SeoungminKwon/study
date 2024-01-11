package backjun.bronze;

import java.util.Scanner;

public class B11655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ret = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                if (c + 13 >= 'Z' + 1) {
                    c = (char) (c + 13 - 'Z' + 64);
                }else{
                    c = (char) (c + 13);
                }
            }else if(c >= 'a' && c <= 'z'){
                if (c + 13 >= 'z' + 1) {
                    c = (char) (c + 13 - 'z' + 96);
                }else{
                    c = (char) (c + 13);
                }
            }
            ret += c;
        }
        System.out.println(ret);
    }
}
