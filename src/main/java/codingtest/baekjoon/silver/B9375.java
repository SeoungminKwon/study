package codingtest.baekjoon.silver;

import java.util.*;

public class B9375 {

    static int tc;
    static Map<String, List<String>> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tc = sc.nextInt();
        for (int t = 0; t < tc; t++) {
            int n = sc.nextInt();
            String buffer = sc.nextLine();
            map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String split = sc.nextLine();
                String[] splitArr = split.split(" ");

                List<String> defaultList = map.getOrDefault(splitArr[1], new ArrayList<String>());
                defaultList.add(splitArr[0]);
                map.put(splitArr[1], defaultList);

            }

            int ret = 1;
            for (String key : map.keySet()) {
                List<String> stringList = map.get(key);
                ret *= stringList.size() + 1;
            }

            System.out.println(ret - 1);
        }
    }
}
