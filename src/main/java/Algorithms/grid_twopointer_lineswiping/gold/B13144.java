package Algorithms.grid_twopointer_lineswiping.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13144 {
    // 1 2 3 1 2
    static int n;
    static int[] arr, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        cnt = new int[100004];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        toPoint();
    }

    static void toPoint() {

        long ans = 0;

        int l = 1;
        int r = 0;
        // 현재 위치 l 에서 시작해서 조건 만족할때까지 r을 늘려나간다.
        while (l <= n) {
            // 처음 쓰는 숫자인지, 범위를 안넘는지 체크
            while (r + 1 <= n && cnt[arr[r + 1]] == 0) {
                r++; // 이미 조건을 확인했으므로 안심하고 증가
                cnt[arr[r]]++; // 해당 수 썻으니 썻다고 표시
            }

            ans += r - l + 1;
            // l을 한칸씩 밀면서 볼 것이기 때문에 계산이 끝나고 나면 l을 한칸 밀어준다.
            // 이전 위치의 cnt는 다음번 계산에서 제외하기 위해 cnt[arr[l]]--;
            cnt[arr[l++]]--;
        }
        System.out.println(ans);
    }
}
