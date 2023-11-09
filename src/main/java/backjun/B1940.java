package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B1940 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[15003];
        int n = sc.nextInt();
        int m = sc.nextInt();


        for(int i = 0 ; i< n; i++){
            a[i] = sc.nextInt();
        }
        int ret = 0;
        for(int i = 0 ; i  < n; i++){
            for(int j = i+1; j < n; j++){
                if(a[i] + a[j] == m)ret++;
            }
        }
        System.out.println(ret);
    }
}

