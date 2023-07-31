import java.util.*;

public class Main {    
    public static void main(String[] args) {
        // GCD(n, k) = 1를 만족하는 자연수의 개수 -> 오일러 피 함수의 정의
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();     // 현재 소인수 구성
        long pi = n;                // 서로소의 개수

        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n % i == 0) {            // i가 n의 소인수라면
                pi = pi - (pi / i);     // 서로소의 개수 갱신

                while(n % i == 0) {     // n에서 i인 소인수는 나누기 연산으로 전부 삭제
                    n /= i;
                }
            }
        }

        // 현재 n이 1보다 크면 n이 마지막 소인수이므로 pi 갱신 (n의 제곱근보다 큰 소수는 최대 1개 존재)
        if(n > 1) {
            pi = pi - (pi / n);
        }

        System.out.println(pi);
    }
}