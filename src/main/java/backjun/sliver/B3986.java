package backjun.sliver;


import java.util.Scanner;
import java.util.Stack;

public class B3986 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = "";
        int ret = 0;
        for (int i = 0; i < n; i++) {
            s = sc.next();
            Stack<Character> stk = new Stack<>();

            for (int j = 0; j < s.length(); j++) {


                if(!stk.empty() && stk.peek() == s.charAt(j)){
                    stk.pop();
                }else{
                    stk.push(s.charAt(j));
                }
            }
            if(stk.empty()){
                ret++;
            }
        }
        System.out.println(ret);

    }
}
