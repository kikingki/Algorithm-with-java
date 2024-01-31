import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static int[][] map;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        queue = new LinkedList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 목표 지점 큐 삽입
                if(map[i][j] == 2) {
                    map[i][j] = 0;
                    queue.add(new int[] {i,j});
                }
            }
         }

        bfs();

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs() {
        while(!queue.isEmpty()) {
         int size = queue.size();   // 같은 거리로 탐색할 수 있는 땅의 개수

         for(int n=0; n < size; n++) {
             int[] current = queue.poll();
             int x = current[0];
             int y = current[1];
             visited[x][y] = true;

             for(int i=0; i<4; i++) {
                 int nx = x + dx[i];
                 int ny = y + dy[i];

                 if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                     if(!visited[nx][ny] && map[nx][ny] == 1) {     // 탐색하지 않았고, 갈 수 있는 땅일 경우
                         map[nx][ny] = map[x][y] + 1;
                         visited[nx][ny] = true;
                         queue.add(new int[] {nx,ny});
                     }
                 }
             }
         }
        }

        checkDistance();
    }

    // 도달할 수 없는 땅 체크
    private static void checkDistance() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    map[i][j] = -1;
                }
            }
        }
    }
}
