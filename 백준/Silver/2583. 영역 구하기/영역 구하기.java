import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static int M,N,area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[M][N];
        ArrayList<Integer> areaList = new ArrayList<>();

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            // 왼쪽 아래 꼭짓점 좌표
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            // 오른쪽 위 꼭짓점 좌표
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            // 직사각형 영역 방문처리
            for(int j=ly; j<ry; j++) {
                for(int k=lx; k<rx; k++) {
                    visited[j][k] = true;
                }
            }
        }

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    area = 0;
                    dfs(j,i);
                    areaList.add(area);
                }
            }
        }

        Collections.sort(areaList);

        StringBuilder sb = new StringBuilder();
        sb.append(areaList.size()).append('\n');
        for(int i : areaList)  {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        visited[y][x] = true;       // 방문 여부 갱신, 영역 넓이 증가
        area++;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < N && ny < M && nx >= 0 && ny >=0) {
                if (!visited[ny][nx]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
