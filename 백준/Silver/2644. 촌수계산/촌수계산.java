import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, end;
    static ArrayList<Integer>[] data;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        data = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) {
            data[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 촌수를 계산해야 해야 하는 노드의 시작점과 도착점
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());


        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            data[parent].add(child);
            data[child].add(parent);
        }

        visited = new boolean[N+1];
        System.out.println(bfs(start));
    }

    private static int bfs(int start){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, 0});     // 시작 노드, 촌수 간 거리
        visited[start] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int node = current[0];
            int dist = current[1];

            // 도착점 도달 ->  종료
            if (node == end) return dist;

            // 현재 노드의 1촌 관계 탐색
            for(int i=0; i<data[node].size(); i++) {
                int next = data[node].get(i);

                if (!visited[next]) {
                    queue.add(new int[]{next, dist+1});
                    visited[next] = true;
                }
            }
        }

        return -1;      // 도착점 도달 불가
    }
}
