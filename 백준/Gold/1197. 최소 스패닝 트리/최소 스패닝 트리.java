import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
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

public class Main {
    static int[] parent;        // 대표 노드 저장 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=1; i<=N; i++) { parent[i] = i; }

        PriorityQueue<Edge> queue = new PriorityQueue<>();  // 우선순위 큐 (가중치 오름차순 자동 정렬)

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            queue.add(new Edge(s,e,w));
        }

        int usedEdge = 1;   // 사용 에지 수 
        int result = 0;     // 가중치 합

        // MST 실행
        while(usedEdge<=N-1) {      // 1번 노드 ~ N-1번 노드
            Edge current = queue.poll();

            int start = current.s;
            int end = current.e;
            int weight = current.w;

            if(find(start) != find(end)) {  // 사이클이 생기지 않을 경우
                union(start, end);
                result += weight;
                usedEdge++;
            }
        }

        System.out.println(result);
    }

    static int find(int a) {    // 재귀
        if(parent[a] == a) return a;
        else {
            parent[a] = find(parent[a]);
            return parent[a];
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a!=b) parent[b] = a; // 대표 노드끼리 연결
     }
}
