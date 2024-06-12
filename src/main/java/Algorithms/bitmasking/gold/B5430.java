package Algorithms.bitmasking.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class B5430 {
    static int n;
    static int tc;
    static String command;
    static String arr;
    static boolean status;
    static Deque<Integer> deque = new LinkedList<>();
    static StringBuilder ret = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            init();
            command = br.readLine();
            n = Integer.parseInt(br.readLine());
            arr = br.readLine();
            String tmp = "";
            for (int i = 0; i < arr.length(); i++) {
                if(arr.charAt(i) == '[' ||  arr.charAt(i) == ']') continue;
                tmp += arr.charAt(i);
            }
            String[] split = tmp.split(",");
            for (String s : split) {
                deque.add(Integer.parseInt(s));
            }


            for (int i = 0; i < command.length(); i++) {
                if (command.charAt(i) == 'R') {
                    reverse();
                } else {
                    if (!remove()) {
                        break;
                    }
                }
            }
            print();
        }
    }

    static void print() {
        if(!ret.equals("error")) {
            ret.append("[");
            for (int i = 0; i < deque.size(); i++) {
                if (status) {
                    ret.append(deque.removeFirst());
                    ret.append(",");
                } else {
                    ret.append(deque.removeLast());
                    ret.append(",");
                }
            }
            ret.append("]");
        }
        System.out.println(ret);
    }

    static boolean remove() {
        if (deque.size() == 0) {
            ret = new StringBuilder("error");
            return false;
        }
        if (status) {
            deque.removeFirst();
        } else {
            deque.removeLast();
        }
        return true;
    }

    static void reverse() {
        status = !status;
    }

    static void init() {
        command = "";
        arr = "";
        deque = new LinkedList<>();
        ret = new StringBuilder();
    }
}
