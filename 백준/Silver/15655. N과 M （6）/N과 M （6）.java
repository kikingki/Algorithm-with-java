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

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];           
        visited = new boolean[N];   
        answer = new int[M];        

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        backtracking(0, 0);
        System.out.print(sb);
    }

    private static void backtracking(int cnt, int start) {
        if(cnt == M) {
            for(int i=0; i<M; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i=start; i<N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            answer[cnt] = nums[i];
            backtracking(cnt+1, i+1);
            visited[i] = false;         
        }
    }
}