package Algorithms.tip;

import java.util.ArrayList;

public class Degree_90_RotationOfArray {
    public static void main(String[] args) {

    }

    //왼쪽으로 90도 회전
    static void rotate90(int[][] key){
        int m = key.length;
        int[][] temp = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = key[j][m - i - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            System.arraycopy(temp[i], 0, key[i], 0, m);
        }
    }

    static void rotate90Right(int[][] key){
        int m = key.length;
        int[][] temp = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = key[m - j - 1][i];
            }
        }
    }
}
