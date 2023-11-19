package backjun.sliver;

import java.util.Scanner;
import java.util.Stack;

public class B4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            String str = sc.nextLine();
            Stack< Character > stk = new Stack<>();
            boolean flag = true;
            if(str.equals(".")){
                break;
            }


            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == '[' || str.charAt(i) == ']'){
                    if(str.charAt(i) == '(' || str.charAt(i) == '['){
                        stk.push(str.charAt(i));
                    }else{
                        if(!stk.isEmpty()){
                            if(stk.peek() == '('){
                                if(str.charAt(i) == ')'){
                                    stk.pop();
                                }else{
                                    flag = false;
                                    break;
                                }
                            }else if(stk.peek() == '['){
                                if(str.charAt(i) == ']'){
                                    stk.pop();
                                }else{
                                    flag = false;
                                    break;
                                }
                            }
                        }else{
                            flag = false;
                            break;
                        }
                    }
                }else{
                    continue;
                }

            }

            if(stk.isEmpty() && flag){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}
