import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M,N;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visied;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            board = new int[N][M];
            visied = new boolean[N][M];

            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                board[y][x] = 1;
            }

            int cnt = 0;        // 필요한 배추흰지렁이 수

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(!visied[i][j] && board[i][j] == 1) {     // 배추가 있는 구역의 시작점 탐색
                        cnt++;
                        dfs(new int[] {i,j});
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void dfs(int[] current) {
        visied[current[0]][current[1]] = true;  // 현재 탐색 여부 갱신

        for(int i=0; i<4; i++) {
            int ny = current[0] + dy[i];
            int nx = current[1] + dx[i];

            // 현재 배추의 인접한 배추 탐색
            if(0<=nx && 0<=ny && nx<M && ny<N) {
                if(!visied[ny][nx] && board[ny][nx] == 1) {
                    visied[ny][nx] = true;
                    dfs(new int[] {ny,nx});     // 인접한 배추에 대한 dfs
                }
            }
        }
    }
}
