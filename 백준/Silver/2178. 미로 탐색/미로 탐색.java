import java.util.*;
import java.io.*;

public class Main {
    // 상하좌우를 탐색하기 위한 define값, 같은 인덱스끼리 조합 -> 상우하좌 방향
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] arr;
    static boolean[][] visited;
    static int N, M;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();   // 공백이 없기 떄문에 우선 문자열로 저장
            for(int j=0; j<M; j++) {
                // substring으로 한 글자씩 저장
                arr[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }
        
        BFS(0,0);
        System.out.println(arr[N-1][M-1]);
	}
    
    private static void BFS(int i, int j) {
        // 좌표가 들어가야하므로 int 배열형 queue
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});
    
        while(!queue.isEmpty()) {
            int[] now = queue.poll();   // 현재 노드
            visited[i][j] = true;       // 현재 노드 방문 기록
            
            for(int k=0; k<4; k++) {    // 상하좌우 탐색
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x>=0 && y>=0 && x<N && y<M) {  // 유효한 좌표(0보다 크고, 배열의 범위를 넘어가지 않음)
                    if(arr[x][y] != 0 && !visited[x][y]) {    // 이동 가능(1)하면서 방문하지 않은 노드
                        // {x,y} 좌표는 방문이 가능하다
                        visited[x][y] = true;       // 방문을 기록하여 queue에 여러 번 추가하는 것을 방지
                        arr[x][y] = arr[now[0]][now[1]] + 1;    // 현재 노드의 depth + 1
                        queue.offer(new int[] {x,y}); 
                    }
                }
            }
        }
    }
}
