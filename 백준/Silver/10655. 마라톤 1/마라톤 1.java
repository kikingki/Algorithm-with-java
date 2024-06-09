import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
이중 for문을 돌면서 모든 체크포인트를 skip하는 경우의 거리 구하기
-> O(N^2) = O(100,000^2) = O(10,000,000,000) -> 시간 초과
모든 체크포인트를 방문한 거리를 구하고, 각 체크포인트를 생락할 경우 절약되는 거리 구하기
-> O(N)
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] point = new int[N][2];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        long distance = 0;
        for(int i=0; i<N-1; i++) {
            distance += getDistance(point[i], point[i+1]);
        }

        long result = distance;
        long temp;
        for(int i=1; i<N-1; i++) {
            // i번째 체크포인트 생략
            temp = distance 
                    - getDistance(point[i], point[i-1]) - getDistance(point[i], point[i+1])
                    + getDistance(point[i-1], point[i+1]);

            result = Math.min(temp, result);
        }

        System.out.println(result);
    }
    private static long getDistance(int[] startPoint, int[] endPoint) {
        return Math.abs(startPoint[0]-endPoint[0]) + Math.abs(startPoint[1]-endPoint[1]);
    }
}
