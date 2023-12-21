package backjun.gold;

import java.util.*;

public class B2632 {
    static int w;
    static int m, n;

    static ArrayList< Integer > pa = new ArrayList<>();
    static ArrayList< Integer > pb = new ArrayList<>();
    static Set< Integer > pas = new HashSet<>();
    static Set< Integer > pbs = new HashSet<>();
    static int ret;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        w = sc.nextInt();
        m = sc.nextInt();
        n = sc.nextInt();

        for (int i = 0; i < m; i++) {
            pa.add(sc.nextInt());
        }

        for (int i = 0; i < n; i++) {
            pb.add(sc.nextInt());
        }


        for (int i = 0; i < pa.size(); i++) {
            int sum = 0; int idx = i;
            for (int j = i; j < pa.size(); j++) {
                if (idx == pa.size()) {
                    idx = idx % pa.size();
                }
                sum += pa.get(idx);
                idx++;
            }
            pas.add(sum);
        }

        for (int i = 0; i < pb.size(); i++) {
            int sum = 0; int idx = i;
            for (int j = 0; j < pb.size(); j++) {
                if (idx == pb.size()) {
                    idx = idx % pb.size();
                }
                sum += pb.get(idx);
                idx++;
            }
            pbs.add(sum);
        }


        for (int i : pas) {
            if(i == w)ret++;
        }

        for (int i : pbs) {
            if(i == w)ret++;
        }

        for (int i : pas) {
            for (int j : pbs) {
                if((i + j) == w)ret++;
            }
        }

        System.out.println(ret);

    }


}
