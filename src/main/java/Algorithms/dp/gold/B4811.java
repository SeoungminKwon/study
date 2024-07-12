package Algorithms.dp.gold;

import java.util.Scanner;

public class B4811 {
    static final int MAX_N = 31; // 최대 입력값
    static long[][] dp = new long[MAX_N][MAX_N]; // 메모이제이션 테이블

    // whole: 온전한 아이템 개수, notWhole: 부분 아이템 개수
    public static long go(int whole, int notWhole) {
        // 기저 조건: 모든 아이템을 배치 완료
        if (whole == 0 && notWhole == 0) {
            return 1; // 한 가지 경우의 수만 존재
        }

        // 이미 계산된 값이면 바로 반환 (메모이제이션)
        if (dp[whole][notWhole] != 0) {
            return dp[whole][notWhole];
        }

        long ret = 0; // 경우의 수 저장 변수

        // 온전한 아이템을 배치하는 경우
        if (whole > 0) {
            ret += go(whole - 1, notWhole + 1);
        }
        // 부분 아이템을 배치하는 경우
        if (notWhole > 0) {
            ret += go(whole, notWhole - 1);
        }

        dp[whole][notWhole] = ret; // 결과 저장
        return ret;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt(); // 입력값 n
            if (n == 0) { // 종료 조건
                break;
            }

            // 메모이제이션 테이블 초기화
            for (int i = 0; i < MAX_N; i++) {
                for (int j = 0; j < MAX_N; j++) {
                    dp[i][j] = 0;
                }
            }

            System.out.println(go(n, 0)); // 결과 출력
        }

        scanner.close(); // Scanner 종료
    }
}
