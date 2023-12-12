package backjun.sliver;

import java.util.*;

public class B1931 {

    static List< Pair > pairs = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(sc.nextLong(), sc.nextLong()));
        }

        Collections.sort(pairs, new Comparator< Pair >() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if(p1.last == p2.last){
                    return (int)(p1.first - p2.first);
                }else{
                    return (int)(p1.last - p2.last);
                }
            }
        });

        long ret  = 0;
        long first = 0;
        long last = 0;

        for (Pair p : pairs) {
            if(last <= p.first){
                last = p.last;
                first = p.first;
                ret++;
            }
        }

        System.out.println(ret);
    }

    static class Pair{
        long first;
        long last;

        public Pair(long first, long last) {
            this.first = first;
            this.last = last;
        }
    }
}
