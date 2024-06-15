package Algorithms.grid_twopointer_lineswiping.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B2109 {
    static int n;
    static int p;
    static int d;
    static int[] dayPay = new int[10004];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.money == o2.money) {
                    return o1.day - o2.day;
                }
                return o2.money - o1.money;
            }
        });

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            pq.add(new Pair(p, d));
        }


        int sum = 0;
        int pqSize = pq.size();
        for (int i = 0; i < pqSize; i++) {
            Pair tmp = pq.poll();
            int reduceDay = tmp.day;
            if(dayPay[tmp.day] != 0){
                while (--reduceDay >= 1) {

                    if(dayPay[reduceDay] != 0)continue;
                    else{
                        dayPay[reduceDay] = tmp.money;
                        break;
                    }
                }
                continue;
            }
            dayPay[tmp.day] = tmp.money;
        }

        for (int i = 0; i <= 10000; i++) {
            sum += dayPay[i];
        }

        System.out.println(sum);

    }

    static class Pair{
        int money;
        int day;

        public Pair(int money, int day) {
            this.money = money;
            this.day = day;
        }
    }
}
