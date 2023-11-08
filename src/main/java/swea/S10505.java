package swea;

import java.util.Scanner;

public class S10505 {
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int num = sc.nextInt();
            int[] arr = new int[num];
            int sum = 0;
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            double d = sum / (double)num;
            int ret = 0;
            for (int i = 0; i < num; i++) {
                if((double)arr[i] < d){
                    ret++;
                }
            }
            System.out.println("#" + test_case + " " + ret);
        }
    }
}


