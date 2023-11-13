import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, days;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] data;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // M: 가로, N: 세로
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        data = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue = new LinkedList<>();

        // 첫날부터 익어있는 토마토 삽입
         for(int i=0; i<N; i++) {
             for(int j=0; j<M; j++) {
                 if(data[i][j] == 1) queue.add(new int[] {j,i});
             }
         }

         days = -1;
         bfs();

        // 탐색 후 익지 않은 토마토가 있는지 확인         
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(data[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(days);
    }

    static void bfs() {
         while (!queue.isEmpty()) {
             int size = queue.size();

             // 하루에 익는 토마토 개수
             for (int n = 0; n < size; n++) {
                 int[] current = queue.poll();

                 // 상하좌우 탐색
                 for (int i = 0; i < 4; i++) {
                     int x = current[0] + dx[i];
                     int y = current[1] + dy[i];

                     if (0 <= x && x < M && 0 <= y && y < N) {
                         if (data[y][x] == 0) {
                             data[y][x] = 1;
                             queue.add(new int[]{x, y});
                         }
                     }
                 }
             }
             days++;
         }
    }
}
