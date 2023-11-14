package backjun.sliver;

import java.util.Scanner;

public class B1992 {
    static int n;
    static char[][] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new char[n][n];

        for(int i = 0; i< n; i++){
            String str = sc.next();
            for(int j = 0; j < n; j++){
                a[i][j] = str.charAt(j);
            }
        }

        System.out.println(go(0, 0, n));


    }

    static String go(int y, int x, int n){
        if(n == 1)return Character.toString(a[y][x]);
        if(check(y, x, n)){
            return Character.toString(a[y][x]);
        }else{
            return "(" + go(y, x, n/2) +
                    go(y, x + n/2 , n/2) +
                    go(y + n/2, x, n/2) +
                    go(y+n/2, x + n/2, n/2) +
                    ")";
        }
    }

    static boolean check(int y, int x, int n){
        char tmp = a[y][x];
        for(int i = y ; i < y+n; i++){
            for(int j = x; j < x+n; j++){
                if(a[i][j] != tmp)return false;
            }
        }

        return true;
    }
}
