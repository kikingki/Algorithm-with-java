import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] period, cost;
    static int maxCost = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        period = new int[N+1];
        cost = new int[N+1];

        for(int i = 1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            period[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 0);
        System.out.println(maxCost);
    }

    private static void dfs(int days, int pay) {
        // 마지막 상담 정보까지 확인한 경우
        if(days == N+1) {
            maxCost = Math.max(maxCost, pay);
            return;
        }

        // 상담을 할 경우, 상담 종료일이 퇴사일을 넘기는지
        if(days + period[days] <= N+1) {
            dfs(days + period[days], pay + cost[days]);
        }
        dfs(days+1, pay);       // 상담을 하지 않고 다음날로 넘어가는 경우
    }
}
