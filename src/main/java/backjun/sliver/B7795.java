package backjun.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List< Integer > a = new ArrayList<>();
            List< Integer > b = new ArrayList<>();
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                a.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                b.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(b);

            for (int i = 0; i < a.size(); i++) {

                int l = 0;
                int r = b.size();
                int mid = 0;

                while (l <= r) {
                    mid = (l + r) / 2;

                    if (a.get(i) < b.get(mid)) {
                        r = mid -1;
                    } else if (a.get(i) > b.get(mid)) {
                        l = mid + 1;
                    }else {

                    }
                }
            }
        }
    }
}
