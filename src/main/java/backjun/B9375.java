package backjun;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B9375 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = 0;
        for (int i = 0; i < n; i++) {
            m = sc.nextInt();

            String str1 = "", str2 = "";
            map.clear();
            for(int j = 0; j < m; j++){
                str1 = sc.next();
                str2 = sc.next();
                map.put(str2, map.getOrDefault(str2, 0) +1);
            }

            int ret = 1;
            for(int num : map.values()){
                ret *= num +1;
            }
            if(map.size() == 1){
                System.out.println(map.get(str2));
            }else{
                System.out.println(ret -1);
            }

        }

    }
}
