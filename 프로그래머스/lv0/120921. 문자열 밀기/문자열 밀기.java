class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        String str = A;
        
        if(A.equals(B)) return 0;
        
        for(int i = 0; i < A.length(); i++) {
            String lastStr = str.substring(str.length()-1);
            str = lastStr + str.substring(0, str.length()-1);
            answer++;

            if(str.equals(B)) return answer;
        }
        return -1;
    }
}