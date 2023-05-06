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
            if(lotto_num == 0) {
                cnt[0]++;
                continue;
            }
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
// 당첨 가능했던 최고 순위, 최저 순위 - 알아볼수없음 0 
// 최고 순위와 최저 순위를 담은 배열 리턴
// 둘 다 정렬하고, lottos의 원소 당 win_nums를 비교, win_nums가 lottos의 원소보다 값이 커지면 break
// 같은 값이 있으면 answer[0]++
// 그리고 0의 개수 만큼 answer[1]++