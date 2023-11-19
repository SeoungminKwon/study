package backjun.gold;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B14502 {

    static int[][] a = new int[10][10];
    static int[][] visited;
    static int[][] copyA;
    static List<Pair> blankList = new ArrayList<Pair>();
    static List<Pair> virusList = new ArrayList<Pair>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] == 0) blankList.add(new Pair(i, j));
                else if(a[i][j] == 2) virusList.add(new Pair(i, j));
            }
        }

        for (int i = 0; i < blankList.size(); i++) {
            for (int j = i + 1; j < blankList.size(); j++) {
                for (int k = j + 1; k < blankList.size(); k++) {

                    for (int q = 0; q < a[0].length; q++) {
                        copyA[q] = a[q].clone();
                    }

                }
            }
        }

    }

    static class Pair{
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
