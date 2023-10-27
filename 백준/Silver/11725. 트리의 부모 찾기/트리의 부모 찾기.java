import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;    // 방문 확인 배열
    static ArrayList<Integer>[] arr;    // 트리
    static int[] parent;        // 부모 노드 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        visited = new boolean[N+1];
        arr = new ArrayList[N+1];

        // 인접리스트의 각 ArrayList 초기화
        for(int i=1; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }

        // 노드의 연결 정보가 "부모 자식" 순서로 정해져서 입력되지 않음 (양방향 연결)
        // 인접리스트에 데이터 저장
        for(int i=1; i<=N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[e].add(s);
            arr[s].add(e);
        }

        dfs(1);

        // 부모 노드 정보 출력
        for(int i=2; i<=N; i++) {
            System.out.println(parent[i]);
        }
    }

    // 재귀
    private static void dfs(int s) {
        if(!visited[s]) {
            visited[s] = true;
            for(int i : arr[s]) {    // s와 연결된 노드들 탐색
                if (!visited[i]) {
                    parent[i] = s;    // 부모 노드 기록
                    dfs(i);
                }
            }
        }
    }
}
