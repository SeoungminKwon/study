package Algorithms.구현.silver;

import java.util.Scanner;

public class B9996 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String buffer = sc.nextLine();
        String pattern = sc.nextLine();
        String[] split = pattern.split("\\*");
        split[1] = new StringBuffer(split[1]).reverse().toString();

        for (int i = 0; i < n; i++) {
            String fileName = sc.nextLine();
            String reverseFilename = new StringBuffer(fileName).reverse().toString();

            if (split[0].length() + split[1].length() <= fileName.length()) {
                if (split[0].equals(fileName.substring(0, split[0].length()))
                            && split[1].equals(reverseFilename.substring(0, split[1].length()))) {
                    System.out.println("DA");
                } else {
                    System.out.println("NE");
                }
            } else {
                System.out.println("NE");
            }



        }

    }
}

/*
6
huhovdjestvarnomozedoci*rnomozedocisvastan
huhovdjestvarnomozedocisvastan
honijezakon
atila
je
bio
hun
 */
