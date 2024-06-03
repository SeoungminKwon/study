package Algorithms.bitmasking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B19942 {
    // 1. 단백질, 지방,  탄수화물, 비타민, 가격
    // 2. 영양소의 합 최소 100, 70, 90, 10
    // 3. 양양소의 합이 기준치를 넘는 경우의 수중 최소 비용의 식자재 집합
    // 4. n 식재료 개수 3 <= n <= 15

    static int n;
    static int[][] arr = new int[18][7];
    static Map<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<>();

    static int dan;
    static int ji;
    static int tan;
    static int vi;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dan = sc.nextInt();
        ji = sc.nextInt();
        tan = sc.nextInt();
        vi = sc.nextInt();

        //입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 경우의 수 (비트마스킹)
        for (int i = 0; i < (1 << n); i++) {
            solve(i);
        }

        // 최솟값 찾기
        int _min = Integer.MAX_VALUE;
        for (Integer sum : map.keySet()) {
            _min = Math.min(_min, sum);
        }

        //map의 값이 존재하지 않다면 -1 출력
        if (map.isEmpty()) {
            System.out.println(-1);
            System.exit(0);
        }
        ArrayList<ArrayList<Integer>> arrayLists = map.get(_min);
        Collections.sort(arrayLists, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
                    if (o1.get(i) != o2.get(i)) {
                        return o1.get(i) - o2.get(i);
                    }
                }
                return o1.size() - o2.size();
            }
        });

        System.out.println(_min);
        ArrayList<Integer> ret = arrayLists.get(0);
        for (Integer i : ret) {
            System.out.print(i+1 + " ");
        }
    }

    static void solve(int bit) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sumd = 0;
        int sumj = 0;
        int sumt = 0;
        int sumv = 0;
        int sump = 0;

        for (int i = 0; i < n; i++) {

            if((bit & (1 << i)) != 0){
                arrayList.add(i);
                sumd += arr[i][0];
                sumj += arr[i][1];
                sumt += arr[i][2];
                sumv += arr[i][3];
                sump += arr[i][4];
            }
        }
        if(sumd == 0 && sumj == 0 && sumt == 0 && sumv == 0) return;
        if (sumd >= dan && sumj >= ji && sumt >= tan && sumv >= vi) {
            ArrayList<ArrayList<Integer>> orDefault = map.getOrDefault(sump, new ArrayList<>());
            orDefault.add(arrayList);
            map.put(sump, orDefault);
        }
    }

}
