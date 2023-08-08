import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());   // 인접 리스트 초기화
        }

        int indegree[] = new int[n+1];  // 진입 차수 배열
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());   // a가 b보다 앞에 서야 함
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);    // a -> b
            indegree[b]++;          // b의 진입 차수 증가
        }

        // 위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            if(indegree[i] == 0) queue.offer(i);   // 진입 차수가 0인 노드를 큐에 삽입
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.println(now);    // 정렬된 순서 출력

            for(int next : graph.get(now)) {     // now와 연결된 노드를 하나씩 확인
                indegree[next]--;       // now와 연결된 노드의 진입 차수 감소
                if(indegree[next] == 0) queue.offer(next);   // 진입 차수가 0이 되면 큐에 삽입
            }
        }
    }
}
