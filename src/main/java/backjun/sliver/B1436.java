package backjun.sliver;

import java.util.Scanner;

public class B1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        long tmp = 0;
        while(true){
            if(Long.toString(++tmp).contains("666")){
                cnt++;
                if(cnt == n){
                    System.out.println(tmp);
                    break;
                }
            }
        }
    }
}
