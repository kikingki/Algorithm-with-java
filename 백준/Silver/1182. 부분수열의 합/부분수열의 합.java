import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int cnt = 0;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(S == 0 ? cnt - 1 : cnt);
    }

    private static void dfs(int depth, int sum) {
        if (depth == N) {           // 부분 수열의 길이가 수열의 전체 길이일 때
            if (sum == S) {
                cnt++;
            }
            return;
        }

        dfs(depth + 1, sum + nums[depth]);              // 원소를 선택했을 경우의 수열의 합
        dfs(depth + 1, sum);                            // 원소를 선택하지 않았을 경우의 수열의 합
    }
}