package Algorithms.bitmasking.gold;

import java.util.Scanner;

public class B14890 {

    static int n, m;
    static int[][] arr = new int[103][103];
    static int ret = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            if(go1(i)) ret++;
            if(go2(i)) ret++;
            System.out.println("i = " + i + " go1 = " + go1(i) + " go2 = " + go2(i));
        }
        System.out.println(ret);
    }

    static boolean go1(int y) {
        int tmp = arr[y][0];

        for (int i = 1; i < n; i++) {
            if(tmp == arr[y][i])continue;
            if (tmp < arr[y][i]) {
                if(i - m < 0)continue;
                for (int j = i - m; j < i; j++) {
                    if(arr[y][j] != arr[y][i] - 1) return false;
                }
                tmp = arr[y][i];
            } else if (tmp > arr[y][i]) {
                if(i + m - 1 >= n)continue;
                for (int j = i + m -1; j > i; j--) {
                    if(arr[y][j] != arr[y][i] + 1) return false;
                }
                tmp = arr[y][i];
            }
        }
        return true;
    }

    static boolean go2(int x) {
        int tmp = arr[0][x];

        for (int i = 1; i < n; i++) {
            if(tmp == arr[i][x])continue;
            if (tmp < arr[i][x]) {
                if(i - m < 0)continue;
                for (int j = i - m; j < i; j++) {
                    if(arr[j][x] != arr[i][x] - 1) return false;
                }
                tmp = arr[i][x];
            } else if (tmp > arr[i][x]) {
                if(i + m-1 > n)continue;
                for (int j = i + m-1; j > i; j--) {
                    if(arr[j][x] != arr[i][x] + 1) return false;
                }
                tmp = arr[i][x];
            }
        }
        return true;
    }

}
