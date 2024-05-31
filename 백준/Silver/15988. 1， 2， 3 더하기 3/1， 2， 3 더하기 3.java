import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // 테스트 케이스마다 dp 배열을 새로 만들어서 다시 계산할 필요 X -> n의 최댓값만큼 미리 1번에 전부 구해놓음
        for(int i=4; i<=1000000; i++) {
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
        }

        while (T > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
            T--;
        }

        System.out.println(sb);
    }
}
