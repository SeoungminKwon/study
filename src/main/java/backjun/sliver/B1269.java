package backjun.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ret = 0;
        HashSet< Integer > setA = new HashSet<>();
        HashSet< Integer > setB = new HashSet<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            setA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        for (Integer i : setA) {
            if(setB.contains(i))cnt++;
        }

        ret = setA.size() - cnt;
        ret += setB.size() - cnt;
        System.out.println(ret);

    }
}
