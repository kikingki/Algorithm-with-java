class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 1~n의 제곱근까지의 약수 i를 구하고, n을 i로 나눈 값도 n의 약수가 된다.
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if (n == 1) return 1;
            
            if (n % i == 0) {
                answer += i;
                if (i != n/i) answer += n/i;
            }
        }
        
        return answer;
    }
}