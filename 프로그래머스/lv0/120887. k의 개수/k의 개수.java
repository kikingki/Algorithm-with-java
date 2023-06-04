class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for(; i <= j; i++) {
            int n = i;
            
            // 자릿수마다 k가 등장하는지 확인
            while(n > 0){
                if(n % 10 == k) answer++;
                n /= 10;
            }
        }
        return answer;
    }
}

// String으로 변환하는 것보다 int 타입 그대로 사용