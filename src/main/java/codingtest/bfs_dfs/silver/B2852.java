package codingtest.bfs_dfs.silver;

import java.util.*;

public class B2852 {
    static int n;
    static int lastTeam, lastTime;
    static int score1, score2;
    static int team1, team2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String buffer = sc.nextLine();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] split = input.split(" ");
            int time = changeTime(split[1]);
            int winTeam = Integer.parseInt(split[0]);

            if (lastTeam == 0) {
                if (winTeam == 1) {
                    team1++;
                    lastTime = time;
                    lastTeam = 1;
                }else {
                    team2++;
                    lastTime = time;
                    lastTeam = 2;
                }
            }else{

                if (lastTeam == 1) {
                    if (winTeam == 1) {
                        // 1팀이 이기고 있었는데 1팀이 이겼을때
                        team1++;
                    }else{
                        team2++;
                        if (team1 == team2) {
                            score1 += time - lastTime;
                            lastTeam = 0;
                            lastTime = time;
                        }
                    }
                }else {
                    if (winTeam == 2) {
                        team2++;
                    }else{
                        team1++;
                        if (team1 == team2) {
                            score2 += time - lastTime;
                            lastTeam = 0;
                            lastTime = time;
                        }
                    }
                }

            }
        }

        int endTime = changeTime("48:00");
        if (team1 != team2) {
            if (team1 > team2) {
                score1 += endTime - lastTime;
            }else{
                score2 += endTime - lastTime;
            }
        }

        System.out.println(reverseTime(score1));
        System.out.println(reverseTime(score2));
    }

    static int changeTime(String time) {
        String[] split = time.split(":");
        int minute = Integer.parseInt(split[0]) * 60;
        int second = Integer.parseInt(split[1]);

        return minute + second;
    }

    static String reverseTime(int time) {
        String minute = "0" + time / 60;
        String second = "0" + time % 60;
        minute = minute.substring(minute.length() - 2, minute.length());
        second = second.substring(second.length() - 2, second.length());
        return minute + ":" + second;
    }
}
