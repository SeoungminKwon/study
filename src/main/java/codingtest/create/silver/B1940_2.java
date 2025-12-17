package codingtest.create.silver;

import java.util.*;
import java.io.*;

public class B1940_2 {

    static int n, m;
    static int[] arr = new int[15_003];
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, new ArrayList<Integer>());
        System.out.println(cnt);
    }

    static void solve(int now, List<Integer> list){
        if (list.size() == 2) {
            if(list.get(0) + list.get(1) == m) cnt++;
            return;
        }

        for (int i = now + 1; i < n; i++) {
            list.add(arr[i]);
            solve(i, list);
            list.remove(list.size() - 1);

        }
    }

}
