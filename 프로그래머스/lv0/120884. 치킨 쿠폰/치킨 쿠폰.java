class Solution {
    public int solution(int chicken) {
        int answer = chicken / 10;              // 서비스 치킨 합계
        int tmp = 0;                            
        int remain = answer + chicken % 10;     
        
        while(remain >= 10) {
            answer += remain / 10;
            tmp = remain / 10;              // 서비스 치킨으로 추가 발급된 쿠폰
            remain = tmp + (remain % 10);   // 현재 가지고 있는 쿠폰 합계
        }
        
        return answer;
    }
}
