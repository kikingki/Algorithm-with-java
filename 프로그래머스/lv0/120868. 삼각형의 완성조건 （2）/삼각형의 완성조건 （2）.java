import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        
        // 나머지 한 변이 가장 긴 변인 경우
        // sides의 최댓값<나머지 한 변<sides[0]+sides[1]
        answer += sides[0]-1;

        // sides 내에서 가장 긴 변이 있는 경우
        // sides[1]<나머지 한 변+sides[0] and 나머지 한 번<sides[1]
        answer += sides[1]-(sides[1]-sides[0]);
        return answer;
    }
}