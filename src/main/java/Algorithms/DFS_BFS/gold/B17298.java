package Algorithms.DFS_BFS.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17298 {
    static int[] ret = new int[1000003];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Pair> stack = new Stack<>();
        int idx = 0;
        while (st.hasMoreElements()) {
            if (stack.isEmpty()) {
                int tmp = Integer.parseInt(st.nextToken());
                stack.push(new Pair(idx, tmp));
            }else{
                int tmp = Integer.parseInt(st.nextToken());
                while (!stack.isEmpty() && stack.peek().value < tmp) {
                    Pair pop = stack.pop();
                    ret[pop.idx] = tmp;
                }
                stack.push(new Pair(idx, tmp));
            }
            idx++;
        }

        while (!stack.isEmpty()) {
            Pair pop = stack.pop();
            ret[pop.idx] = -1;
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < n; i++) {
            bufferedWriter.write(ret[i] + " ");
        }
        bufferedWriter.flush();


    }

    static class Pair{
        int idx;
        int value;

        public Pair(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
