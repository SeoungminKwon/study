package swea;

import java.util.Scanner;

public class S4406 {
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        String buffer = sc.nextLine();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String s = sc.nextLine();
            String ret = "";
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
                    continue;
                }else{
                    ret += s.charAt(i);
                }
            }
            System.out.println("#" + test_case +" "+ret);
        }
    }
}
