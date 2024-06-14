import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int connetion = Integer.parseInt(br.readLine());
        StringTokenizer st;

        data = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) {
            data[i] = new ArrayList<>();
        }

        for(int i=0; i<connetion; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            data[s].add(e);
            data[e].add(s);
        }

        System.out.println(bfs(1));
    }

    private static int bfs(int start) {
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new ArrayDeque<>();
        
        // 1번 컴퓨터
        q.add(start);
        visited[start] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int current = q.poll();
            
            // 한 depth의 컴퓨터 탐색
            for(int i=0; i<data[current].size(); i++) {
                int next = data[current].get(i);
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
