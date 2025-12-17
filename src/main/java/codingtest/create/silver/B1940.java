package codingtest.create.silver;

import java.util.*;


public class B1940 {
    static int n, m;
    static int[] arr = new int[15_004];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if(arr[i] + arr[j] == m) cnt++;
            }
        }

        System.out.println(cnt);
    }
}
