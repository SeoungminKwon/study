package backjun;

import java.util.Scanner;

public class B11655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ret ="";
        for(int i = 0; i < s.length(); i++){
            //대문자
            if(s.charAt(i) >= 65 && s.charAt(i) <= 91){
                // 90 초과
                if(s.charAt(i) + 13 >= 65 + 26) {
                    ret += (char) (s.charAt(i) + 13 - 91 + 65);
                }else{
                    ret += (char)(s.charAt(i) + 13);
                }

            }else if(s.charAt(i) >= 97 && s.charAt(i) <= 122){

                if(s.charAt(i) + 13 >= 97 + 26){
                    ret += (char)(s.charAt(i) + 13 - 123 + 97);
                }else{
                    ret += (char)(s.charAt(i) + 13);
                }
            }else{
                ret += s.charAt(i);
            }
        }
        System.out.println(ret);
    }
}
