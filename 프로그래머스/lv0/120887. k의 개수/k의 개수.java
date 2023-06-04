class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String strK = Integer.toString(k);
        
        for(; i <= j; i++) {
            String[] strI = Integer.toString(i).split("");
            for(String s : strI) {
                if(s.equals(strK)) answer += 1;
            }
        }
        return answer;
    }
}