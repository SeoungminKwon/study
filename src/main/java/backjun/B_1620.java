package backjun;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B_1620 {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        Map<Integer, String> map2 = new HashMap<Integer, String>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        String temp = "";
        for (int i = 1; i <= n; i++) {
            temp = sc.next();
            map1.put(temp, i);
            map2.put(i, temp);
        }

        for (int i = 0; i < m; i++) {
            temp = (String)sc.next();
            boolean flag = true;
            for(int j = 0; j < temp.length(); j++){
                if(!Character.isDigit(temp.charAt(j))){
                    flag = false;
                    break;
                }
            }

            if(flag){
                System.out.println(map2.get(Integer.parseInt(temp)));
            }else{

                System.out.println(map1.get(temp));
            }
        }
    }
}
