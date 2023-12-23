import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] nums, answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N개의 자연수 중 M개를 고른 수열
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];           // 입력받은 자연수
        visited = new boolean[N];   // 방문 여부 확인
        answer = new int[M];        // 수열

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);       // 사전순 출력을 위해 오름차순 정렬

        backtracking(0);
        System.out.print(sb);
    }

    // M개를 선택할 수 있는 수열의 모든 경우를 탐색
    private static void backtracking(int cnt) {
        // M개의 숫자를 선택한 경우, 현재까지 선택한 수열을 출력하고 종료
        if(cnt == M) {
            for(int i=0; i<M; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 바로 직전 수열 마지막 값(before)과 새로 추가되는 값(nums[i])이 같을 때, 중복되는 수열이 만들어지므로, 현재 수를 건너뛰고 다음 수를 검사
        // nums 배열이 오름차순으로 되어있기 때문에 가능
        int before = 0;
        for(int i=0; i<N; i++) {
            if (visited[i]) continue;

            if(before != nums[i]) {
                visited[i] = true;
                answer[cnt] = nums[i];
                before = nums[i];
                backtracking(cnt+1);    // 재귀 호출로 다음 숫자를 선택
                visited[i] = false;         // 재귀 호출이 끝나면 현재 선택한 수에 대한 상태를 초기화하기 위해 visited[i] = false로 설정
            }
        }
    }
}