package ssafy;

import java.util.*;

public class Solutuon2 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();

            ArrayList< Integer > arr = new ArrayList<>();
            Map< Integer, Integer > map = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {
                int tmp = sc.nextInt();
                arr.add(tmp);
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
            int result =-987654321;
            for(int i = 1; i < arr.size() -1; i++){
                for(int j = 1; j <arr.size() -1; j++){
                    int ret = 0;
                    for(int k = i; k <= j; k++){
                        ret += map.get(arr.get(k));
                        if(ret >= A && ret <= B){
                            result = Math.max(result, ret);
                        }
                    }
                }
            }
            System.out.println("#"+tc +" "+ result);
        }
    }
}
