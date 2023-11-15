package backjun.sliver;

import java.util.*;

public class B2910 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        ArrayList< Num > nums = new ArrayList<>();
        Map< Integer, Integer > map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int[] a = new int[n];

        for(int i = 0 ; i < n; i++){
            a[i] = sc.nextInt();
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            map2.put(a[i], map2.getOrDefault(a[i], i));
        }

        for(int i = 0; i < n; i++){
            nums.add(new Num(map2.get(a[i]), a[i], map.get(a[i])));
        }

        Collections.sort(nums, new NumComparator());

        for(int i = 0;  i < nums.size(); i++){
            System.out.print(nums.get(i).num + " ");
        }

    }

}

class Num {
    public int idx;
    public int num;
    public int cnt;

    public Num(int idx, int num, int cnt) {
        this.idx = idx;
        this.num = num;
        this.cnt = cnt;
    }
}

class NumComparator implements Comparator<Num>{
    @Override
    public int compare(Num n1, Num n2) {
        if(n1.cnt == n2.cnt){
            return Integer.compare(n1.idx, n2.idx);
        }
        return Integer.compare(n2.cnt, n1.cnt);
    }


}