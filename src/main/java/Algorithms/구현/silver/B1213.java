package Algorithms.구현.silver;

import java.util.Scanner;

public class B1213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] alpha = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 65]++;
        }

        // 팰린드롬 체크
        int cnt = 0;
        int oddNumIdx = -1;
        for (int i = 0; i < 26; i++) {
            if(alpha[i] % 2 != 0){
                cnt++;
                oddNumIdx = i;
            }
        }
        if (cnt > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }


        //팰린드롬 만들기
        String retl = "";
        String retr = "";
        for (int i = 0; i < 26; i++) {
            if(alpha[i] == 0)continue;
            if(i == oddNumIdx && alpha[i] == 1)continue;

            int n = alpha[i] / 2;
            for (int j = 0; j < n; j++) {
                retl += (char)(i + 65);
                retr = (char)(i + 65) + retr;
            }
        }
        if (oddNumIdx == -1) {
            System.out.println(retl + retr);
        }else {
            System.out.println(retl + (char)(oddNumIdx + 65) + retr);
        }
    }
}
