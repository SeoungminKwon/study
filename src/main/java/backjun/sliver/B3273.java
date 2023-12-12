package backjun.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B3273 {

    static int[] a = new int[1000004];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }


//        System.out.println(s);
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(a,0,n);
        int left = 0;
        int right = n -1;
        int ret = 0;
        while(true){
            if(left == right)break;
            if(a[left] + a[right] == x){
                ret++;
                left++;
            }
            else if(a[left] + a[right] > x)right--;
            else if(a[left] + a[right] < x)left++;
        }

        System.out.println(ret);

    }
}
