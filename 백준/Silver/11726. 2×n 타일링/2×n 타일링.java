import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        n개의 숫자로 순열을 만들 때
        하나의 숫자의 자리가 정해지는 경우 나머지 숫자들로 만들 수 있는 경우의 수 = (n-1)!
        2개의 숫자가 정해져 있다면 (n-2)!
        1*2 타일로 채우는 것 - 1개의 자리 지정, 2*1 타일로 채우는 것 = 2*2 타일 고정 - 2개의 자리 지정
         */
        /*
        if (n=4인 경우)
        n=3인 경우에서 제일 오른쪽에 1x2타일을 하나 붙인 것과 모양이 동일 = 제일 오른쪽 부분은 1x2로 고정 = (n-1) 경우의 수 = dp[n-1]
        제일 오른쪽 부분에 2x2를 채울 수 있음 = 직사각형의 제일 오른쪽 2칸은 이미 정해져 있다는 것 = (n-2) 경우의 수 = dp[n-2]
        dp[n] = dp[n-1] + dp[n-2]
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n+1];
        dp[1] = 1;

        if(n>=2) {
            dp[2] = 2;
        }

        for(int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
