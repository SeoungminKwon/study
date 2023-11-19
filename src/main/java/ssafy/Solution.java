package ssafy;

import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            ArrayList< Integer > arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }
            arr.sort(Comparator.reverseOrder());

            int ret = 0;
            int max = 0;
            while(!arr.isEmpty()){
                max = arr.get(0);
                ret += max;
                arr.remove(0);
                for(int i = 0; i < arr.size(); i++){
                    if(max > arr.get(i)){
                        arr.remove(i);
                        break;
                    }
                }
            }

            System.out.println("#" + tc + " " + ret);
        }
    }
}
