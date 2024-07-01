import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=1; i<=N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }

        visited = new boolean[N+1];
        parents = new int[N+1];
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i=2; i<=N; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int node) {
        if(!visited[node]) {
            visited[node] = true;
            for(int i : arr[node]) {    
                if (!visited[i]) {
                    parents[i] = node;    
                    dfs(i);
                }
            }
        }
    }
}
