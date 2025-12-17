package codingtest.bfs_dfs.silver;

import java.io.*;
import java.util.*;

public class B1436 {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long num = 0;
        while (n != 0) {
            num++;
            String temp = num + "";
            if(temp.contains("666"))n--;
        }
        System.out.println(num);
    }
}
