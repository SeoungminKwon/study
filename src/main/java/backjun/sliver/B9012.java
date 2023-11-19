package backjun.sliver;

import java.util.Scanner;
import java.util.Stack;

public class B9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            Stack< Character > stk = new Stack<>();
            boolean flag = true;
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '('){
                    stk.push(str.charAt(j));
                }else{
                    if(!stk.isEmpty()){
                        stk.pop();
                    }else{
                        flag = false;
                        break;
                    }
                }
            }

            if(stk.isEmpty() && flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
