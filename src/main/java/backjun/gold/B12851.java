package backjun.gold;

import java.util.Scanner;

public class B12851 {

    static int _max;
    static int _min;
    static int[] arr = new int[200004];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        _max = Math.max(n, k);
        _min = Math.min(n, k);

        arr[_min] = 1;
        for(int i = 0; i <= 100000; i++){
            //+1
            if(arr[i + 1] != 0){
                arr[i+1] = Math.min(arr[i+1], arr[i] +1);
            }else{
                arr[i+1] = arr[i] + 1;
            }
            //x2
            if(arr[i * 2] != 0){
                arr[i * 2] = Math.min(arr[i*2], arr[i] + 1);
            }else{
                arr[i * 2] = arr[i] + 1;
            }

            if(i != 0){
                if(arr[i-1] != 0){
                    arr[i-1] = Math.min(arr[i-1], arr[i] +1);
                }else{
                    arr[i-1] = arr[i] +1;
                }
            }

            if(i != 0 && i % 2 == 0){
                if(arr[i/2] != 0){
                    arr[i/2] = Math.min(arr[i/2], arr[i] +1);
                }else{
                    arr[i/2] = arr[i] +1;
                }
            }

        }
        System.out.println(arr[10] -1);
    }
}
