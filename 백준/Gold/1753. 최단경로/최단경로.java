import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node n) {
        return this.weight - n.weight;
    }
}

public class Main {
    static ArrayList<Node>[] graph; // 방향 그래프
    static boolean[] visited;   // 방문 확인 배열
    static int[] dist;  // 최단 거리 배열
    static int V, E, K;

    public static void main(String[] args) throws IOException {
        // 최단 경로 구하기, 모든 간선의 가중치는 10 이하의 자연수(양수)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());   // 정점의 개수
        E = Integer.parseInt(st.nextToken());   // 간선의 개수
        K = Integer.parseInt(br.readLine());    // 시작 노드

        graph = new ArrayList[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 1. 인접 리스트로 그래프 데이터 삽입
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, w));
        }

        dist = new int[V + 1];

        // 2. 최단 거리 배열 초기화하기
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(K);

        for(int i=1; i<=V; i++) {
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }

    private static void dijkstra(int K) {
        // 3. 값이 가장 작은 노드 고르기
        PriorityQueue<Node> queue = new PriorityQueue<>();  // 우선순위 큐를 사용하면 항상 최단 거리로 진행 중인 노드가 맨 위에 위치
        queue.add(new Node(K, 0));  // 시작 노드 선택
        dist[K] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int curEnd = current.end;

            // 1번 선택된 노드는 다시 선택X
            if (visited[curEnd]) continue;
            visited[curEnd] = true;

            // 선택된 노드에 연결된 다른 노드의 값 업데이트
            for (Node node : graph[curEnd]) {
                if(dist[node.end] > dist[curEnd] + node.weight) {
                    dist[node.end] = dist[curEnd] + node.weight;
                    queue.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}
