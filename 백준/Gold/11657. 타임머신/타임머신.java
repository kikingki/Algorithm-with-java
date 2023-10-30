import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int s, e, w;

    public Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}

// 도시의 개수 N(1 ≤ N ≤ 500), 버스 노선의 개수 M(1 ≤ M ≤ 6,000), 둘째 줄부터 M개의 줄에는 버스 노선의 정보 A, B, C (1 ≤ A, B ≤ N, -10,000 ≤ C ≤ 10,000) -> 오버플로우 주의!
public class Main {
    static int N, M;    // 노드 개수, 에지 개수
    static Edge[] edges;    // 에지 정보 저장 리스트
    static long[] distance;  // 노드별 최단 거리 리스트
    static boolean check;   // 음수 사이클 존재 여부
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new Edge[M+1];
        distance = new long[N+1];

        // 에지 정보 저장
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(s, e, w);
        }

        // 거리 리스트 초기화
        for(int i=1; i<=N; i++) {
            distance[i] = INF;
        }

        bellmanFord();

        // 음수 사이클 여부에 따라 출력
        if(check) System.out.println(-1);
        else {
            for (int i = 2; i <= N; i++) {
                if (distance[i] != INF) System.out.println(distance[i]);
                else System.out.println(-1);
            }
        }
    }

    static void bellmanFord() {
        distance[1] = 0;

        for(int i=1; i<=N-1; i++) {     // N-1만큼 반복
            for(int j=1; j<=M; j++) {   // 에지 개수만큼 반복
                Edge current = edges[j];
                if(distance[current.s] != INF && distance[current.e] > distance[current.s]+ current.w) {
                    distance[current.e] = distance[current.s]+ current.w;       // 업데이트
                }
            }
        }

        // 음수 사이클 존재 여부 확인
        for(int i=1; i<=M; i++) {
            Edge current = edges[i];
            if (distance[current.s] != INF && distance[current.e] > distance[current.s] + current.w) {
                check = true;
                break;
            }
        }
    }
}
