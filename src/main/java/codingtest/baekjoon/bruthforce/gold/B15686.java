package codingtest.baekjoon.bruthforce.gold;

import java.io.*;
import java.util.*;


public class B15686 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, m;
    static int[][] arr = new int[53][53];
    static List<Pair> homeList = new ArrayList<>();
    static List<Pair> chickenList = new ArrayList<>();
    static int[] visitedChicken = new int[15];
    static int result = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 도시의 치킨거리는 모든 집의 치킨 거리의 합
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                Pair pair = new Pair(i, j);
                int number = Integer.parseInt(input[j]);
                if (number == 1) {
                    homeList.add(pair);
                } else if (number == 2) {
                    chickenList.add(pair);
                }
                arr[i][j] = number;
            }
        }

        List<Integer> reduceList = new ArrayList<>();
        reduceChicken(reduceList);
        System.out.println(result);

    }

    static class Pair{
        int y;
        int x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void reduceChicken(List<Integer> reduceList) {
        if (reduceList.size() == m) {
            calculateStreet(reduceList);
            return;
        }else{
            for (int i = 0; i < chickenList.size(); i++) {
                if(visitedChicken[i] != 0) continue;
                visitedChicken[i] = 1;
                reduceList.add(i);
                reduceChicken(reduceList);
                visitedChicken[i] = 0;
            }
        }
    }

    static void calculateStreet(List<Integer> reduceList) {
        for (int i = 0; i < homeList.size(); i++) {
            Pair pair = homeList.get(i);
            Queue<Pair> q = new LinkedList<>();
            int[][] visited = new int[53][53];
            for (int[] init : visited) {
                Arrays.fill(init, Integer.MAX_VALUE);
            }

            q.add(pair);
            visited[pair.y][pair.x] = 1;

            while (q.size() != 0) {
                Pair now = q.poll();
                for (int j = 0; j < 4; j++) {
                    int ny = now.y + dy[j];
                    int nx = now.x + dx[j];

                    if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                    if(arr[ny][nx] != 1) continue;
                    if(visited[ny][nx] != Integer.MAX_VALUE) continue;

                    visited[ny][nx] = visited[now.y][now.x] + 1;
                    q.add(new Pair(ny, nx));
                }
            }

            int sum = 0;
            for (int j = 0; j < reduceList.size(); j++) {
                Pair chickenPair = chickenList.get(reduceList.get(j));
                sum += visited[chickenPair.y][chickenPair.x];
            }
            result = Math.min(result, sum);
        }
    }

}
