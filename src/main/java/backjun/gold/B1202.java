package backjun.gold;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1202 {

    static int n, k, m, v, c;
    static List< Jew > jews = new ArrayList<>();
    static List< Integer > bags = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jews.add(new Jew(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < k; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(bags, new Comparator< Integer >() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 -o2;
            }
        });
        Collections.sort(jews, new Comparator< Jew >() {
            @Override
            public int compare(Jew o1, Jew o2) {
                if(o1.weight == o2.weight){
                    return o2.price - o1.price;
                }else{
                    return o1.weight - o2.weight;
                }
            }
        });

        int sum = 0;
        int temp = 0;
        for (int i = 0; i < k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < jews.size(); j++) {
               if(bags.get(i) <jews.get(j).weight){
                   break;
               }
               max = Math.max(max, jews.get(j).price);
            }
        }

        System.out.println(sum);
    }

    static class Jew{
        int weight;
        int price;
        public Jew(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }
}
