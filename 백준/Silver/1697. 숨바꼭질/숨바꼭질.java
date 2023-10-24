import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] visited = new int[100001];
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            System.out.println(n - k);
        } else {
            System.out.println(bfs());
        }
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 1;

        // 시간복잡도 - 최악의 경우 O(100,000)이다. 즉, O(V) v:위치의 수
        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                // 다음으로 이동할 수 있는 경우의 수
                if (i == 0) next = current - 1;
                else if (i == 1) next = current + 1;
                else next = current * 2;

                if (next == k) return visited[current];

                // 다음 위치가 범위(0 ≤ N ≤ 100,000) 내에 있고, 이동하지 않았던 위치일 경우
                if (next >= 0 && next < 100001 && visited[next] == 0) {
                    visited[next] = visited[current] + 1;
                    queue.add(next);
                }
            }
        }
        return 0;
    }
}

