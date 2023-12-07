package backjun.gold;

import java.util.*;

public class B19942 {

    static int n;
    static int mp, mf, ms, mv;

    static List< Ingredient > ingredients = new ArrayList<>();

    static List< Pair > pairList = new ArrayList<>();

    public static void main(String[] args) {

        List< String > strings = new ArrayList<>();
        strings.add("1 2 3 4");
        strings.add("1 2 3");


        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        mp = sc.nextInt();
        mf = sc.nextInt();
        ms = sc.nextInt();
        mv = sc.nextInt();

        for (int i = 0; i < n; i++) {
            ingredients.add(new Ingredient(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }


        for (int i = 0; i < (1 << n); i++) {
            //초기화
            int sum = 0;
            Ingredient retIng = new Ingredient(0, 0, 0, 0, 0);
            String s = "";
            for (int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0 ){
                    retIng.p += ingredients.get(j).p;
                    retIng.f += ingredients.get(j).f;
                    retIng.s += ingredients.get(j).s;
                    retIng.v += ingredients.get(j).v;
                    sum += ingredients.get(j).c;
                    s += j+1 + " ";
                }
            }

            if(retIng.p >= mp && retIng.f >= mf && retIng.s >= ms && retIng.v >= mv){
                pairList.add(new Pair(s, sum));
            }
        }


        Collections.sort(pairList, new Comparator<Pair>() {
            @Override
            public int compare(Pair pair1, Pair pair2) {
                // sum이 같으면 s를 오름차순으로 정렬
                if (pair1.sum == pair2.sum) {
                    return pair1.s.compareTo(pair2.s);
                }
                // sum이 다르면 sum을 오름차순으로 정렬
                return Integer.compare(pair1.sum, pair2.sum);
            }
        });

        if(pairList.isEmpty()){
            System.out.println("-1");
        }else{
            System.out.println(pairList.get(0).sum);
            System.out.println(pairList.get(0).s);
        }

    }

    static class Ingredient {
        int p; int f; int s; int v; int c;

        public Ingredient(int p, int f, int s, int v, int c) {
            this.p = p;
            this.f = f;
            this.s = s;
            this.v = v;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Ingredient{" +
                    "p=" + p +
                    ", f=" + f +
                    ", s=" + s +
                    ", v=" + v +
                    ", c=" + c +
                    '}';
        }
    }

    static class Pair{
        String s;
        int sum;

        public Pair(String s, int sum) {
            this.s = s;
            this.sum = sum;
        }
    }




}
