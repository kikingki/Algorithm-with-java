import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        // 그리디 알고리즘으로 풀 수 있도록 i ≥ 2인 경우에 Ai는 Ai-1의 배수라는 조건 부여
        int[] coins = new int[N];  
        
        for(int i=0; i<N; i++) {
            coins[i] = sc.nextInt();
        }
        
        // 그리디 알고리즘 구현 -> 최대한 큰 동전 먼저 사용
        int count = 0;
        for(int i=N-1; i>=0; i--) {
            if(K >= coins[i]) {
                count += K / coins[i];
                K = K % coins[i];
            }
        }
        System.out.println(count);
    }
}