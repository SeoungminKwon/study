package codingtest.baekjoon.dfs_bfs.silver;

import java.io.*;

public class B2852 {
    static int n;
    static int team1, team2, score1, score2, prevTime = -1, team;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            team = Integer.parseInt(temp[0]);
            String stringTime = temp[1];
            int time = parseTime(stringTime);

            plusTeamScore(team);
            if (score1 == score2) {
                equalTeamScore(team, time);
                prevTime = -1;
            }else{
                if (prevTime == -1) {
                    prevTime = time;
                }
            }
        }

        if (score1 != score2) {
            if (team == 1) {
               team1 += parseTime("48:00") - prevTime;
            }else{
                team2 += parseTime("48:00") - prevTime;
            }
        }

        System.out.println(retTime(team1));
        System.out.println(retTime(team2));

    }

    static String retTime(int time) {
        int minute = time / 60;
        int second = time % 60;
        String strMinute = "0" + minute;
        String strSecond = "0" + second;

        return strMinute.substring(strMinute.length() - 2) + ":" + strSecond.substring(strSecond.length() - 2);
    }



    static void equalTeamScore(int team, int time) {
        if (score1 == score2) {
            if (team == 1) {
                team2 += time - prevTime;
            }else{
                team1 += time - prevTime;
            }
        }
        return;
    }

    static void plusTeamScore(int team) {
        if (team == 1) {
            score1++;
        }else{
            score2++;
        }
    }

    static int parseTime(String time) {
        String[] times = time.split(":");
        int minute = Integer.parseInt(times[0]);
        int second = Integer.parseInt(times[1]);

        return minute * 60 + second;
    }
}
