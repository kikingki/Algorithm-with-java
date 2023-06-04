class Solution {
    public String solution(String bin1, String bin2) {
        String answer = "0";
        
        // 문자열 -> 숫자 변환. 진수 지정 가능
        int num1 = Integer.parseInt(bin1, 2);
        int num2 = Integer.parseInt(bin2, 2);
        
        // 숫자 -> 2진수 문자열
        answer = Integer.toBinaryString(num1+num2);
        
        return answer;
    }
}

// 직접 진수 계산을 하려니까 어려웠는데, 진수 변환이 되는 함수를 쓰면 쉽게 풀리는 문제였다.