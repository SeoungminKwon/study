package Algorithms.DFS_BFS.silver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B2910 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();

        HashMap hashMap = new HashMap<Integer, SortObj>();

        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if (hashMap.get(tmp) == null) {
                SortObj sortObj = new SortObj(tmp, 1, i);
                hashMap.put(tmp, sortObj);
            }else{
                SortObj sortObj = (SortObj) hashMap.get(tmp);
                sortObj.count++;
            }
        }

        ArrayList<SortObj> sortObjs = new ArrayList<>();
        for (Object value : hashMap.values()) {
            SortObj sortobj = (SortObj) value;
            sortObjs.add(sortobj);
        }
        Collections.sort(sortObjs, new Comparator<SortObj>() {
            @Override
            public int compare(SortObj o1, SortObj o2) {
                if (o1.count == o2.count) {
                    return o1.idx - o2.idx;
                }
                return o2.count - o1.count;
            }
        });

        for (SortObj sortObj : sortObjs) {
            int count = sortObj.count;
            for (int i = 0; i < count; i++) {
                System.out.print(sortObj.num + " ");
            }
        }


    }

    static class SortObj{
        int num;
        int count;
        int idx;

        public SortObj(int num, int count, int idx) {
            this.num = num;
            this.count = count;
            this.idx = idx;
        }
    }
}
