import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        // 편의점의 x좌표와 고객간의 x좌표의 거리 + 편의점의 y좌표와 고객간의 y좌표의 거리 -> x,y는 거리 계산식에 서로 영향을 주지 않음
        int[] coordinateX = new int[n];
        int[] coordinateY = new int[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            coordinateX[i] = Integer.parseInt(st.nextToken());
            coordinateY[i] = Integer.parseInt(st.nextToken());
        }

        // 각 고객들의 이동 거리의 합을 최소화하려면 x 좌표와 y 좌표 각각의 중앙값을 선택하는 것이 최적
        Arrays.sort(coordinateX);
        Arrays.sort(coordinateY);

        int midX = coordinateX[n/2];
        int midY = coordinateY[n/2];
        long distance = 0;      // 거리의 값이 매우 큼 -> long 사용

        /*
        x 좌표와 y 좌표를 각각 따로 정렬 : O(n log n)
        정렬된 리스트의 중앙값을 선택 : O(1)
        중앙값을 기준으로 각 고객들의 위치로부터의 이동 거리의 합을 계산 : O(n)
        -> 총 시간 복잡도는 O(n log n) + O(n) = O(n log n)
         */
        for(int i=0; i<n; i++) {
            distance += Math.abs(midX - coordinateX[i]) + Math.abs(midY - coordinateY[i]);
        }

        System.out.println(distance);
    }
}
