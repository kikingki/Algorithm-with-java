import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0,0};
        int[] cnt = {0,0};
        
        HashMap<Integer, Integer> rank = new HashMap() {{
            put(6,1);
            put(5,2);
            put(4,3);
            put(3,4);
            put(2,5);
            put(1,6);
            put(0,6);
        }};
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        for(int lotto_num : lottos) {
            // 최고 등수는 0이 모두 로또 번호인 경우
            if(lotto_num == 0) {
                cnt[0]++;
                continue;
            }
            // lottos의 원소마다 win_nums를 비교, win_nums가 lottos의 원소보다 값이 커지면 break
            for(int win_num : win_nums) {
                if(lotto_num == win_num) {
                    cnt[1]++;
                }
                else if(lotto_num < win_num) break;
            }
        }
        
        cnt[0] += cnt[1];
        
        answer[0] = rank.get(cnt[0]);
        answer[1] = rank.get(cnt[1]);
        
        return answer;
    }
}