import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        // 가로는 두 변중에서 긴 길이, 세로는 두 변중에서 작은 길이으로 일치시켜준다. ex) [30,70] -> [70,30]
        int max_v = 0;
        int max_h = 0;
        
        for(int i=0; i<sizes.length; i++){
            int tmp_v = Math.max(sizes[i][0], sizes[i][1]);     // 각 카드의 가로 길이
            int tmp_h = Math.min(sizes[i][0], sizes[i][1]);     // 각 카드의 세로 길이
            
            max_v = Math.max(max_v, tmp_v); 
            max_h = Math.max(max_h, tmp_h);
        }
        
        return max_v * max_h;
    }
}