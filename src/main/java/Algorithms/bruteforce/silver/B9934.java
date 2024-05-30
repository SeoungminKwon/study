package Algorithms.bruteforce.silver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

public class B9934 {
    static int k;
    static int[] arr;
    static ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        int pow = (int) Math.pow(2, k);
        arr = new int[pow -1];
        for (int i = 0; i < pow -1; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 10; i++) {
            arrayLists.add(new ArrayList<>());
        }

        print(0, pow -2, 0);

        for (ArrayList<Integer> arrayList : arrayLists) {
            if(arrayList.isEmpty())continue;
            for (Integer i : arrayList) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static void print(int start, int end, int level) {
        ArrayList<Integer> arrayList = arrayLists.get(level);
        int n = (start + end) / 2;
        if (start >= end) {;
            arrayList.add(arr[n]);
            return;
        }
        arrayList.add(arr[n]);
        print(start, n - 1, level + 1);
        print(n + 1, end, level + 1);
    }

}
