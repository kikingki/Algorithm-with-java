import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1, 2, 3, ..., n까지의 수를 더해서 합이 S가 되는 지점
수열의 합 공식에 따르면, 1부터 n까지의 합은 N*(N+1)/2
주어진 S에 대해 가능한 최대 n을 찾기 위해서는 이 합이 S보다 작거나 같아야 함
-> N*(N+1)/2 <= S를 만족시킬 때까지 반복
-> O(√S) -> √4,294,967,295
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        int N = 1;

        for (int i = 1; i <= S; i++) {
            S -= i;
            N++;
        }

        System.out.println(N-1);    // N까지의 합이 S보다 커진 순간 제외
    }
}
