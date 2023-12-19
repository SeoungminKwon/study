package backjun.sliver;

import java.util.*;

public class B14888 {

    static int n;
    static int[] nums = new int[13];
    static List<Integer> opers = new ArrayList<>();
    static int _max = Integer.MIN_VALUE;
    static int _min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            int tmp = sc.nextInt();
            for (int j = 0; j < tmp; j++) {
                opers.add(i);
            }
        }

        go(1, new int[13], new ArrayList<>());

        System.out.println(_max);
        System.out.println(_min);

    }

    static void go(int dept, int[] visited, List<Integer> ret){
        if (dept == n) {
            op(ret);
        }

        for (int i = 0; i < opers.size(); i++) {
            if(visited[i] != 0)continue;
            visited[i] = 1;
            Integer tmp = i;
            ret.add(tmp);
            go(dept + 1, visited, ret);
            ret.remove(tmp);
            visited[i] = 0;
        }
    }

    static void op(List<Integer> ret){
        int[] tmp = new int[13];
        for (int i = 0; i < n; i++) {
            tmp[i] = nums[i];
        }

        for (int i = 1; i < n; i++) {
            int num1 = tmp[i - 1];
            int num2 = tmp[i];

            int operator = opers.get(ret.get(i-1));
            if(operator == 0){
                tmp[i] = num1 + num2;
            } else if (operator == 1) {
                tmp[i] = num1 - num2;
            } else if (operator == 2) {
                tmp[i] = num1 * num2;
            }else{
                tmp[i] = num1 / num2;
            }
        }

        _min = Math.min(_min, tmp[n-1]);
        _max = Math.max(_max, tmp[n-1]);
    }
}
