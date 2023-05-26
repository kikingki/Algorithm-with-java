class Solution {
    public int solution(int n) {
        int answer = 0;
 
        for (int i = 0; i < n; i++) {
            answer++;
            //'3'을 포함하고 있는 숫자는 String으로 변환해서 확인
            while (answer % 3 == 0 || String.valueOf(answer).contains("3")) { 
                answer++;
            }
        }
        return answer;
    }
}