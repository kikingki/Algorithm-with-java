import java.awt.geom.Area;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Area {
        int x, y;

        public Area(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean[][] visited;
    static int[][] data;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N][N];
        Set<Integer> heights = new HashSet<>();     // 안전 영역에 영향을 주는 강수량 : 아무 지역도 잠기지 않는 경우 + 각 지역의 높이

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                heights.add(data[i][j]);
            }
        }

        int answer = 1;
        for(Integer h : heights) {
            visited = new boolean[N][N];
            int cnt = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    // 물에 잠기지 않는 영역 count
                    if(!visited[i][j] && data[i][j] > h) {
                        bfs(i,j,h);
                        cnt++;
                    }
                }
            }
            answer = Math.max(cnt, answer);
        }

        System.out.println(answer);
    }

    static void bfs(int x, int y, int h) {
        Queue<Area> q = new ArrayDeque<>();

        visited[x][y] = true;
        q.add(new Area(x,y));

        while (!q.isEmpty()) {
            Area current = q.poll();
            for(int i=0; i<4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(inSpace(nx, ny) && !visited[nx][ny] && data[nx][ny] > h) {
                    visited[nx][ny] = true;
                    q.add(new Area(nx, ny));
                }
            }
         }
    }

    static boolean inSpace(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
