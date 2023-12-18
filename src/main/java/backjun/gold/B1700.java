package backjun.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B1700 {
    public static void main(String[] args) throws IOException {
        int arr[] = new int[104];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator< Integer >() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return arr[o2] - arr[o2];
            }
        });

        for (int i = 0; i < k; i++) {

        }

    }
}
