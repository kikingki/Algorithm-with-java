import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 기둥 개수 N, 기둥 정보를 담은 2차원 배열 int[][] pillars = new int[N][2];
// 좌우에서 최대 높이의 기둥까지 면적을 별도로 계산한 후, 가장 높은 기둥을 기준으로 왼쪽과 오른쪽의 면적을 합산

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] pillars = new int[N][2];

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            pillars[i][0] = Integer.parseInt(st.nextToken());
            pillars[i][1] = Integer.parseInt(st.nextToken());
        }

        // 위치순 정렬
        Arrays.sort(pillars, (o1, o2) -> o1[0] - o2[0]);

        int area = 0;

        // 왼쪽부터 최대 높이로 갈 때까지
        int leftMaxHeight = 0;
        int leftMaxIndex = 0;
        for (int i = 0; i < N; i++) {
            if (pillars[i][1] >= leftMaxHeight) {
                area += (pillars[i][0] - pillars[leftMaxIndex][0]) * leftMaxHeight;
                leftMaxHeight = pillars[i][1];
                leftMaxIndex = i;
            }
        }

        // 오른쪽부터 최대 높이로 갈 때까지
        int rightMaxHeight = 0;
        int rightMaxIndex = N - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (pillars[i][1] >= rightMaxHeight) {
                area += (pillars[rightMaxIndex][0] - pillars[i][0]) * rightMaxHeight;
                rightMaxHeight = pillars[i][1];
                rightMaxIndex = i;
            }
        }

        // 중앙에서 최대 높이 기둥의 면적 더하기
        area += leftMaxHeight * (pillars[rightMaxIndex][0] - pillars[leftMaxIndex][0] + 1);

        System.out.println(area);
    }
}
