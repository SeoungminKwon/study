package backjun.sliver;


import java.io.*;
import java.util.*;

public class B2776 {

    static List<Integer> a;
    static List<Integer> b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            a = new ArrayList<>();
            b = new ArrayList<>();


            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(st.nextToken()));
            }
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(a);

            for (int i = 0; i < m; i++) {
                if(binary(b.get(i))){
                    bw.write("1\n");
                }else {
                    bw.write("0\n");
                }
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static boolean binary(int num) {
        int l = 0;
        int r = a.size() - 1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if(num == a.get(mid)) return true;
            else if(num < a.get(mid)) r = mid -1;
            else if(num > a.get(mid)) l = mid + 1;
        }
        return false;
    }
}
