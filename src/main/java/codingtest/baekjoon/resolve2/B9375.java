package codingtest.baekjoon.resolve2;

import java.util.*;

/**
 * 3/6 : 1시간 시간 초과
 */
public class B9375 {

    static int tc;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tc = sc.nextInt();

        for (int t = 0; t < tc; t++) {
            int n = sc.nextInt();
            String buffer = sc.nextLine();
            Map<String, List<String>> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String temp = sc.nextLine();
                String[] srtArr = temp.split(" ");
                String category = srtArr[1];
                String cloth = srtArr[0];

                List<String> cloths = map.getOrDefault(category, new ArrayList<String>());
                cloths.add(cloth);
                map.put(category, cloths);
            }

            int ret = 1;
            for (String key : map.keySet()) {
                ret *= map.get(key).size() + 1;
            }

            System.out.println(ret -1);
        }
    }
}
