package codingtest.baekjoon.dfs_bfs.silver;

import java.util.*;
import java.io.*;

public class B2870 {
    static int n;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();


            StringBuilder number = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                if (c >= 'a' && c <= 'z') {
                    if(!number.isEmpty()) {
                        numbers.add(number.toString());
                        number = new StringBuilder();
                    }
                }else{
                    number.append(c);
                }
            }

            if (!number.isEmpty()) {
                numbers.add(number.toString());
            }
        }




    }

//    static void removeZero(List<String> numbers) {
//
//        List<String> ret = new ArrayList<>();
//        for (String number : numbers) {
//
//            while (true) {
//                if (number.charAt(0) == '0') {
//                    if(number)
//                }
//            }
//        }
//    }


}
