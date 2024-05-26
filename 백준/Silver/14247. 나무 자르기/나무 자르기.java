import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
완전 탐색
1. 나무 정렬 -> n log n -> 영향 x
2. 나무를 자르는 순서를 결정하는 경우의 수 -> 순열 n!개 * 각 순열별 나무 길이 계산 n번
=> O(n * n!) -> 100,000 * 100,000! -> 완탐 X
 */
/*
그리디
자라는 속도가 느린 나무부터 먼저 자르면 자라는 속도가 빠른 나무를 최대한 많이 자라게 할 수 있음 -> 매일 가장 키 큰 나무를 자를 필요 X
-> 성장 속도가 제일 빠른 나무를 마지막날에 자르면 됨. e.g. 7씩 자라는 나무는 n일 후 = 초기 길이 + 7*n일
-> 정렬 O(n log n), 나무 자르기 O(n) -> O(n log n)
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long answer = 0L;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            answer += Long.parseLong(st.nextToken());    // 모든 나무를 1번씩은 자르므로 초기의 나무 길이를 미리 더함
        }

        int[] growth = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            growth[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(growth);

        for(int day=0; day<n; day++) {
            answer += (long) growth[day] * day;
        }

        System.out.println(answer);
    }
}
