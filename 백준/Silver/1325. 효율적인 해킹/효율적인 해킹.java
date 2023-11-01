import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] counts;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        counts = new int[N+1];
        arr = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s].add(e);
        }

        for(int i=1; i<=N; i++) {
            visited = new boolean[N + 1];
            dfs(i); // 노드별 해킹할 수 있는 컴퓨터 탐색
        }

        // 컴퓨터 번호 출력
        int max = counts[1];
        for (int i = 2; i <= N; i++) {
            if(counts[i]>max) max = counts[i];
        }
        for (int i = 1; i <= N; i++) {
            if(counts[i]==max) System.out.print(i + " ");
        }
    }

    private static void dfs(int s) {
//        counts[s]++;
        // 시작점 탐색
        if(!visited[s]) {
            visited[s] = true;

            for(int i : arr[s]) {    // s와 연결된 노드들 탐색
                if (!visited[i]) {
                    counts[i]++;
                    dfs(i);
                }
            }
        }
    }
}
