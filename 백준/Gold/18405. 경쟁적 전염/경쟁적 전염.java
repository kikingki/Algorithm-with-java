import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] graph;
    static PriorityQueue<Virus> queue;

    static class Virus implements Comparable<Virus> {
        int x;
        int y;
        int number;
        int time;

        public Virus(int x, int y, int number, int time) {
            this.x = x;
            this.y = y;
            this.number = number;
            this.time = time;
        }

        // 같은 시간 ASC, 동일할 경우 번호 ASC
        @Override
        public int compareTo(Virus other) {
            if(this.time == other.time) {
                return Integer.compare(this.number, other.number);
            }
            return Integer.compare(this.time, other.time);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        queue = new PriorityQueue<>();  // 우선순위 큐에 저장할 객체는 필수적으로 Comparable Interface를 구현해야한다.

        // 값을 입력받으면서 바이러스가 있는 위치를 큐에 삽입
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] != 0) {
                    queue.add(new Virus(i,j,graph[i][j],0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(graph[X][Y]);
    }
    
    private static void bfs() {
        while (!queue.isEmpty()) {
            Virus current = queue.poll();

            if(current.time == S) return;   // S초에 도달하면 종료

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (0 < nx && nx <= N && 0 < ny && ny <= N) {
                    if (graph[nx][ny] == 0) {
                        graph[nx][ny] = current.number; // 전염
                        queue.add(new Virus(nx, ny, current.number, current.time+1));
                    }
                }
            }
        }
    }
}