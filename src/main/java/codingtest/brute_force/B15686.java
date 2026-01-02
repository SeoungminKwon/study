package codingtest.brute_force;

import java.io.*;
import java.util.*;

public class B15686 {

    static int n, m;
    static List<Pair> homeList = new ArrayList<>();
    static List<Pair> chickenList = new ArrayList<>();
    static int[][] arr = new int[53][53];
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());

                if(num == 1) homeList.add(new Pair(i, j));
                else if(num == 2) chickenList.add(new Pair(i, j));

                if(num != 2) arr[i][j] = num;

            }
        }

        select(-1, new ArrayList<Pair>());
        System.out.println(ret);
    }

    static void select(int now, List<Pair> selected) {
        if (selected.size() == m) {

            int minStreet = 0;
            for (int i = 0; i < homeList.size(); i++) {

                Pair home = homeList.get(i);

                int min = Integer.MAX_VALUE;
                for (int j = 0; j < selected.size(); j++) {
                    Pair chicken = selected.get(j);
                    min = Math.min(min, (Math.abs(home.y - chicken.y) + Math.abs(home.x - chicken.x)));
                }

                minStreet += min;
            }
            ret = Math.min(ret, minStreet);
        }
        for (int i = now + 1; i < chickenList.size(); i++) {
            Pair pair = chickenList.get(i);
            selected.add(pair);
            select(i, selected);
            selected.remove(selected.size() - 1);
        }
    }



    static class Pair{
        int y;
        int x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
