package backjun.gold;

import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack< Integer > stk = new Stack<>();
        String[] sArray = br.readLine().split(" ");
        int n = Integer.parseInt(sArray[0]);
        sArray = br.readLine().split(" ");
        int[] ret = new int[n];
        Arrays.fill(ret, -1);


        for (int i = 0; i < sArray.length; i++) {

            while(!stk.empty() && Integer.parseInt(sArray[stk.peek()]) < Integer.parseInt(sArray[i])){
                ret[stk.peek()]  = Integer.parseInt(sArray[i]);
                stk.pop();
            }
            stk.push(i);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ret[i] + " ");
        }
        System.out.println(sb);
    }
}
