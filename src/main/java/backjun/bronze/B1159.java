package backjun.bronze;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B1159 {
    static int[] ap = new int[26];
    static List< Character > characters = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            ap[s.charAt(0) - 'a']++;
        }

        for(int i=  0; i < 26; i++){
            if(ap[i] >= 5){
                characters.add((char) (97 + i));
            }
        }

        if (characters.size() == 0) {
            System.out.println("PREDAJA");
        }else{
            for (int i = 0; i < characters.size(); i++) {
                System.out.print(characters.get(i));
            }
        }
    }
}
