package backjun.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B2170 {

    static int n;
    static int x, y;

    static ArrayList< Line > list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            list.add(new Line(x, y));
        }

        Collections.sort(list, new Comparator< Line >() {
            @Override
            public int compare(Line o1, Line o2) {
                if (o1.l == o2.l) {
                    return o1.r - o2.r;
                }
                return o1.l - o2.l;
            }
        });

        int l = list.get(0).l;
        int r = list.get(0).r;
        int sum = 0;
        for (Line line : list) {

            if (r < line.l){
                sum += r-l;
                l = line.l;
                r = line.r;
            }else{
                if(l > line.l){
                    l = line.l;
                }
                if(r < line.r){
                    r = line.r;
                }
            }

        }
        sum += r -l;

        System.out.println(sum);
    }
}

class Line{
    int l;
    int r;

    public Line(int l, int r) {
        this.l = l;
        this.r = r;
    }
}
