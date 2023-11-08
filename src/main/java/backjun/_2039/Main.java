package backjun._2039;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a[] = new int[9];
        for(int i = 0; i < 9; i++){
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += a[i];
        }

        for(int i = 0; i < 9; i++){
            for(int j = i+1; j < 9; j++){
                if((sum - a[i] - a[j]) == 100){
                    for(int k = 0; k < 9; k++){
                        if(k == i || k == j)continue;
                        System.out.println(a[k]);
                    }
                    return;
                }
            }
        }
    }
}
