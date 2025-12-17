package codingtest.create.silver;

import java.util.*;
import java.io.*;

public class B4375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int input = sc.nextInt();

            int ret = 1;
            int res = 1;
            int size = Integer.toString(input).length();
            boolean flag = true;
            while (flag) {
                if(size > ret){
                    ret++;
                    res = res * 10 + 1;
                    continue;
                }else{
                    if (res < input) {
                        ret++;
                        res = res * 10 + 1;
                    }else{
                        int temp = res % input;
                        if (temp == 0) {
                            flag = false;
                        }else{
                            ret++;
                            res = temp * 10 + 1;
                        }
                    }
                }
            }

            System.out.println(ret);
        }
    }
}
