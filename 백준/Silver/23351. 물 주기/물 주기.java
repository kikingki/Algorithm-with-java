import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
각 반복마다 O(A + N + N log N)의 시간복잡도
모든 화분의 초기 수분량이 K이므로, 각 화분은 수분량이 0이 될 때까지 최대 K번의 감소
=> O(K * (A + N + N log N)) = O(1)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 초기값 세팅
        int[] arr = new int[N];
        Arrays.fill(arr, K);

        int answer = 0;

        // 수분이 0이 되면 종료
        while (arr[0]>0) {
            for(int i=0; i<A; i++) {
                arr[i] += B;
            }
            for(int i=0; i<N; i++) {
                arr[i]--;
            }
            Arrays.sort(arr);       // 가장 수분이 부족한 화분에 물을 주도록 정렬
            answer++;
        }

        System.out.println(answer);
    }
}
