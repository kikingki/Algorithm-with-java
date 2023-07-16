import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        arr = new ArrayList[n+1]; // 인접리스트를 n의 개수만큼 생성
        
        // 인접리스트의 각 ArrayList 초기화
        for(int i=1; i<n+1; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        
        // 인접리스트에 데이터 저장
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            // 양방향
            arr[s].add(e);  // 2 -> 5
            arr[e].add(s);  // 5 -> 2
        }
        
        int count = 0;      // 연결요소의 개수
        for(int i=1; i<n+1; i++) {
            // 방문하지 않은 노드가 있으면
            if(!visited[i]) { 
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
    
    private static void DFS(int v) {
        // 현재 노드가 방문한 노드이면
        if(visited[v]) { 
            return ;
        } else {
            visited[v] = true;    // 현재 노드 방문 기록

            // 연결 노드 중 방문하지 않은 노드
            for(int i : arr[v]) {
                if(!visited[i]) {
                    DFS(i);
                }
            }
        }
    }
}