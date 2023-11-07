import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] t = new int[N];   // 상담을 완료하는데 걸리는 기간
        int[] p = new int[N];   // 각 상담을 했을 때 받을 수 있는 금액
        int[] dp = new int[N+1];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<N; i++) {
            int end = i+t[i];   // i번째 상담을 마친 날짜
            if(end <= N) {
                dp[end] = Math.max(dp[end], dp[i]+p[i]);  // dp[i]는 i일까지의 최대 이익, i번째 상담을 선택했을 때와 선택하지 않았을 때의 두 가지 경우
            }

            /*
            상담을 선택한 경우: 현재 상담을 마친 날짜(i+t[i])의 최대 이익(dp[i+t[i]])은 현재 최대 이익(dp[i])에 현재 상담의 이익(p[i])을 더한 값입니다. 이 값과 dp[i+1] 중 큰 값을 dp[i+t[i]]에 저장합니다.
            상담을 선택하지 않은 경우: dp[i+1]은 dp[i]와 같은 값으로 업데이트합니다. 즉, 이전까지의 최대 이익을 그대로 가져갑니다.
             */
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[N]);
    }
}
