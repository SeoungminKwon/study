package codingtest.baekjoon.bruthforce.gold;

import java.io.*;
import java.util.*;


public class B15686 {
    static int n, m;
    static int[][] arr = new int[53][53];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int result = Integer.MAX_VALUE;
    static List<Pair> chickenList = new ArrayList<>();
    static List<Pair> homeList = new ArrayList<>();
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    chickenList.add(new Pair(i, j));
                } else if (num == 1) {
                    homeList.add(new Pair(i, j));
                    arr[i][j] = num;
                }else{
                    arr[i][j] = num;
                }
            }
        }

        chose(new ArrayList<Integer>(), 0);
        System.out.println(result);



    }

    static void chose(List<Integer> idxList, int start) {
        if (idxList.size() == m) {
            int[][] copyArr = new int[53][53];
            for (int i = 0; i < n; i++) {
                System.arraycopy(arr[i], 0, copyArr[0], 0, arr[i].length);
            }

            try {
                for (int idx : idxList) {
                    Pair chosenChicken = chickenList.get(idx);
                    copyArr[chosenChicken.y][chosenChicken.x] = 2;
                }
            } catch (Exception e) {
                System.out.println("here");
            }



            int street = 0;
            for (Pair home : homeList) {
                int[][] visited = new int[53][53];
                visited[home.y][home.x] = 1;

                Queue<Pair> q = new LinkedList<>();
                q.add(home);

                while (!q.isEmpty()) {
                    Pair pair =  q.poll();

                    for (int i = 0; i < 4; i++) {
                        int ny = pair.y + dy[i];
                        int nx = pair.x + dx[i];

                        if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                        if(visited[ny][nx] != 0) continue;
                        if(copyArr[ny][nx] == 1) continue;

                        visited[ny][nx] = visited[pair.y][pair.x] + 1;
                        q.add(new Pair(ny, nx));
                    }

                }

                int min = Integer.MAX_VALUE;
                for (int idx : idxList) {
                    Pair chosenChicken = chickenList.get(idx);
                    min = Math.min(min, visited[chosenChicken.y][chosenChicken.x]);
                }

                street += min;
            }
            result = Math.min(result, street);
        }else{
            for (int i = start; i < chickenList.size(); i++) {
                idxList.add(Integer.valueOf(i));
                chose(idxList, start + 1);
                idxList.remove(Integer.valueOf(i));
            }
        }
    }

    static class Pair{
        int y;
        int x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
