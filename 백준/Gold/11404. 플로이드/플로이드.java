import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long[][] distance;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        distance = new long[N+1][N+1];

        // 인접 행렬 초기화
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i==j) distance[i][j] = 0;    // 시작 도시와 종료 도시가 같은 경우
                else distance[i][j] = INF;
            }
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());


            if(distance[s][e] > w) distance[s][e] = w;  // 동일 경로일 경우 최솟값
        }

        // 플로이드-워셜
        floyd();

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(distance[i][j] == INF) System.out.print(0 + " ");
                else System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void floyd() {
        for(int k=1; k<=N; k++) {       // k가 가장 바깥쪽
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
    }
}
