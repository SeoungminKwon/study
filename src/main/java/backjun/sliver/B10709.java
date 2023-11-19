package backjun.sliver;

import java.util.Scanner;

public class B10709 {
    static int h, w;
    static int[][] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        a = new int[h][w];


        for (int i = 0; i < h; i++) {
            boolean flag = false;
            int cnt = -1;
            String s = sc.next();
            for (int j = 0; j < w; j++) {
                char c = s.charAt(j);
                if(c == 'c'){
                    flag = true;
                    a[i][j] = 0;
                    cnt = 0;
                }else{
                    if(flag){
                        a[i][j] = ++cnt;
                    }else{
                        a[i][j] = cnt;
                    }
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }
}
