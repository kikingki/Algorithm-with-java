import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0,1,0,-1,-1,1,1};
    static int[] dy = {0,1,0,-1,1,-1,1,-1};
    static int[][] graph;
    static boolean[][] visited;
    static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            int cnt = 0;

            // "0 0"이면 테스트 케이스 종료
            if (w == 0 && h == 0) {
                break;
            }

            graph = new int[h][w];
            visited = new boolean[h][w];

            // 지도 데이터 입력
            for(int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    //  visited 배열을 통해 이미 방문한 위치를 다시 처리하지 않도록 하고, graph 배열을 통해 육지인 위치만을 선택하여 섬의 일부를 찾아냄
                    if (!visited[i][j] && graph[i][j] == 1) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.add(new int[]{y, x});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            // 8방향 탐색
            for(int i=0; i<8; i++) {
                int nowX = current[1] + dx[i];
                int nowY = current[0] + dy[i];

                if (nowX >= 0 && nowY >= 0 && nowX < w && nowY < h) {
                    if (!visited[nowY][nowX] && graph[nowY][nowX] == 1) {
                        queue.add(new int[]{nowY, nowX});
                        visited[nowY][nowX] = true;
                    }
                }
            }
        }
    }
}



