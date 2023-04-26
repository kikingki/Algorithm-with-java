import java.util.Arrays;
 
// spell이 있으면 다른 문자로 치환하고, 치환한 문자의 개수가 spell의 개수면 1을 리턴
class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        
        for(int i=0; i < dic.length; i++) {
            String tmp = dic[i];
            for(String spe : spell) {
                tmp = tmp.replaceFirst(spe, "?");
            }
            dic[i] = tmp;
        }
            
        for(String str : dic) {
            int dicCount = str.length() - str.replace("?", "").length();
            if(dicCount == spell.length) return 1;
        }
        return answer;
    }
}