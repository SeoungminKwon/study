package backjun.gold;

import java.sql.Array;
import java.util.*;

public class B15662 {
    static int t, k;
    static int l, r;
    static List< Integer > eff = new ArrayList<>();
    static List< Gear > gearList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String buffer = sc.nextLine();
        for (int i = 0; i < t; i++) {
            String s = sc.nextLine();
            Deque< Integer > dq = new ArrayDeque<>();

            for (int j = 0; j < s.length(); j++) {
                dq.add(s.charAt(j) - '0');
                if(j == 2){
                    if((s.charAt(j) - '0') == 1)r = 1;
                    else r = 0;
                }

                if(j == 6){
                    if((s.charAt(j) - '0') == 1)l = 1;
                    else l = 0;
                }
            }
            gearList.add(new Gear(l, dq, r));

        }


        k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int n = sc.nextInt() -1;
            int r = sc.nextInt();
            eff = new ArrayList<>();

            oper(n, r);
        }

        System.out.println(ret());
    }

    static int ret() {
        int cnt = 0;
        for (int i = 0; i < gearList.size(); i++) {
            Integer first = gearList.get(i).dq.getFirst();
            if(first == 1)cnt++;
        }
        return cnt;
    }


    static void oper(int idx, int vec) {
        if(vec == 1){
            leftCheck(idx-1, gearList.get(idx).left, -1);
            rightCheck(idx+1, gearList.get(idx).right, -1);
        }else{
            leftCheck(idx-1, gearList.get(idx).left, 1);
            rightCheck(idx+1, gearList.get(idx).right, 1);
        }

        Deque< Integer > dq = gearList.get(idx).dq;
        if(vec == 1){
            Integer i = dq.pollLast();
            dq.addFirst(i);
        }else{
            Integer i = dq.pollFirst();
            dq.addLast(i);
        }

        ArrayList< Integer > arrayList = new ArrayList<>();
        while (!dq.isEmpty()) {
            arrayList.add(dq.pollFirst());
        }
        gearList.get(idx).right = arrayList.get(2);
        gearList.get(idx).left = arrayList.get(6);

        for (int i = 0; i < arrayList.size(); i++) {
            dq.addLast(arrayList.get(i));
        }
    }

    static void leftCheck(int idx ,int left, int vec) {
        if(idx < 0)return;
        if(gearList.get(idx).right == left)return;
        if(vec == 1){
            leftCheck(idx -1, gearList.get(idx).left, -1);
        }else{
            leftCheck(idx -1, gearList.get(idx).left, 1);
        }

        Gear gear = gearList.get(idx);
        Deque< Integer > dq = gear.dq;

        if(vec == 1){
            Integer i = dq.pollLast();
            dq.addFirst(i);
        }else{
            Integer i = dq.pollFirst();
            dq.addLast(i);
        }
        ArrayList< Integer > arrayList = new ArrayList<>();
        while (!dq.isEmpty()) {
            arrayList.add(dq.pollFirst());
        }
        gearList.get(idx).left = arrayList.get(6);
        gearList.get(idx).right = arrayList.get(2);

        Deque< Integer > dq2 = new ArrayDeque<>();
        for (int i = 0; i < arrayList.size(); i++) {
            dq2.addLast(arrayList.get(i));
        }
        gearList.get(idx).dq = dq2;
    }

    static void rightCheck(int idx ,int right, int vec) {
        if(idx >= gearList.size())return;
        if(gearList.get(idx).left == right)return;
        if(vec == 1){
            rightCheck(idx +1, gearList.get(idx).right, -1);
        }else{
            rightCheck(idx +1, gearList.get(idx).right, 1);
        }

        Gear gear = gearList.get(idx);
        Deque< Integer > dq = gear.dq;

        if(vec == 1){
            Integer i = dq.pollLast();
            dq.addFirst(i);
        }else{
            Integer i = dq.pollFirst();
            dq.addLast(i);
        }
        ArrayList< Integer > arrayList = new ArrayList<>();
        while (!dq.isEmpty()) {
            arrayList.add(dq.pollFirst());
        }
        gearList.get(idx).left = arrayList.get(6);
        gearList.get(idx).right = arrayList.get(2);

        Deque< Integer > dq2 = new ArrayDeque<>();
        for (int i = 0; i < arrayList.size(); i++) {
            dq2.addLast(arrayList.get(i));
        }
        gearList.get(idx).dq = dq2;
    }




}

class Gear{
    int left;
    Deque<Integer> dq;
    int right;

    public Gear(int left, Deque< Integer > dq, int right) {
        this.left = left;
        this.dq = dq;
        this.right = right;
    }


}
