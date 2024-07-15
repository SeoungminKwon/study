package Algorithms.dp.silver;

import java.util.ArrayList;
import java.util.Scanner;

public class B12852 {


    static ArrayList<Integer>[] dp = new ArrayList[100004];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //초기화
        for (int i = 0; i <= 100000; i++) {
            dp[i] = new ArrayList<Integer>();
        }

        ArrayList<Integer> tmp = new ArrayList<>();

        go(n, tmp);

        System.out.println(dp[1].size() -1);
        for (int i : dp[1]) {
            System.out.print(i + " ");
        }

    }

    static void go(int n, ArrayList<Integer> path) {
        if(n <= 0)return;
        path.add(n);


        if (dp[n].size() > 0) {
            if (dp[n].size() > path.size()) {
                dp[n] = new ArrayList<>(path);
            }
        } else {
            dp[n] = new ArrayList<>(path);
        }



        //로직
        go(n -1, new ArrayList<Integer>(path));
        if(n % 2 == 0)go(n / 2, new ArrayList<Integer>(path));
        if(n % 3 == 0)go(n / 3, new ArrayList<Integer>(path));
    }


}
