package backjun;

import java.util.Arrays;
import java.util.Scanner;

public class B1213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int a[] = new int[26];

        for(int i = 0; i < str.length(); i++){
            a[str.charAt(i) - 'A']++;
        }
        String str1 = "", str2 = "", str3 = "";
        int cnt = 0;
        boolean flag = true;
        for(int i = 0 ; i < 26; i++){
            for(int j = 0; j < a[i] / 2; j++){
                str1 += (char)(i + 65);
                str3 = (char)(i + 65) + str3;
            }
            if(a[i] % 2 != 0){
                str2 += (char)(i + 65);
                cnt++;
            }

            if(cnt >= 2){
                flag = false;
                break;
            }
        }

        if(flag){
            System.out.println(str1 + str2 + str3);
        }else{
            System.out.println("I\'m Sorry Hansoo");
        }

    }
}
