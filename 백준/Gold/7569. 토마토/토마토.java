import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    static int[] dx = {0,1,0,-1,0,0};
    static int[] dy = {1,0,-1,0,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static int[][][] data;
    static Queue<Tomato> queue;

    // 토마토의 좌표 정보와 익은 날짜를 담은 객체
    static class Tomato {
        int x;
        int y;
        int z;
        int day;

        public Tomato(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // M: y, N: x, H: z
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        data = new int[H][N][M];

        for(int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    data[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        queue = new LinkedList<>();

        // 처음부터 익어있는 토마토 정보 삽입
        for(int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (data[k][i][j] == 1) queue.add(new Tomato(i,j,k,0));
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        int day = 0;
        
        while (!queue.isEmpty()) {
            Tomato current = queue.poll();
            day = current.day;
            
            // 상하좌우 앞뒤 탐색
            for(int i=0; i<6; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int nz = current.z + dz[i];

                if (0 <= nx && 0 <= ny && 0 <= nz && nx < N && ny < M && nz < H) {
                    if(data[nz][nx][ny] == 0) {
                        data[nz][nx][ny] = 1;
                        queue.add(new Tomato(nx,ny,nz,day+1));
                    }
                }
            }
        }

        if(!checkZero()) return -1;
        return day;     // 가장 마지막으로 익은 토마토의 일수
    }

    // 토마토가 모두 익었는지 확인
    static boolean checkZero() {
        for(int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (data[k][i][j] == 0) return false;
                }
            }
        }
        return true;
    }
}
