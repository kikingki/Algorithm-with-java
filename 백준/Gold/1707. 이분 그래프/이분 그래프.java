import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;  // 그래프 데이터 저장 인접 리스트
    static int[] check;             // 이분 그래프 체크 배열
    static boolean[] visited;       // 방문 체크 배열
    static boolean flag;     // 이분 그래프 판별 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());        // 테스트 케이스 개수

        for (int t = 0; t < testCase; t++) {
            String[] data = br.readLine().split(" ");    // 공백을 기준으로 노드 개수, 에지 개수
            int V = Integer.parseInt(data[0]);           // 노드 개수
            int E = Integer.parseInt(data[1]);           // 에지 개수(간선 개수)

            // 0번째 인덱스는 사용하지 않음
            graph = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            flag = true;

            // V의 개수만큼 arr 인접 리스트의 각 arraylist 초기화
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<Integer>();
            }

            // E의 개수만큼 arr 인접 리스트에 그래프 데이터 저장
            for (int j = 0; j < E; j++) {
                String[] edge = br.readLine().split(" ");
                int start = Integer.parseInt(edge[0]);
                int end = Integer.parseInt(edge[1]);

                // 무방향 그래프이므로 양방향으로 저장
                graph[start].add(end);
                graph[end].add(start);
            }

            // 모든 노드에서 DFS 실행 -> 결과가 이분 그래프가 아니면 반복 종료
            for(int i=1; i<=V; i++) {
                if(flag) dfs(i);
                else break;
            }

            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    // dfs 구현 (재귀 형태)
    static void dfs(int start) {
        visited[start] = true;      // 현재 노드에 대한 방문 기록
        // graph[start]는 현재 노드에 연결된 모든 노드들의 리스트 -> 모든 노드들에 대해서 방문 여부 확인
        for(int node : graph[start]) {
            if(!visited[node]) {    
                // 바로 직전에 있는 노드와 다른 집합으로 분류 (0, 1, 0, 1, 0, 1, ...)
                check[node] = (check[start] + 1) % 2;
                dfs(node);
            } else if(check[start] == check[node]) {    // 이미 방문한 노드가 현재 노드와 같은 집합이면 이분 그래프가 아님
                    flag = false;
            }
        }
    }
}
