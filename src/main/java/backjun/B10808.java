package backjun;

import java.util.Scanner;

public class B10808 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.reverse();
        String str2 = stringBuffer.toString();

        if(str.equals(str2)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
