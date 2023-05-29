import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        HashMap<Integer, Integer> distance = new HashMap<>();
        
        // 각 원소별 거리 구하기
        for(int i = 0; i<numlist.length; i++) {
            distance.put(numlist[i], Math.abs(n-numlist[i]));
        }
        
        // Collection.sort()을 사용하여 key값을 기준으로 정렬한 뒤, comparator를 사용하여 Value 값으로 내림차순 정렬
        List<Integer> keySet = new ArrayList<>(distance.keySet());
        Collections.sort(keySet);
        keySet.sort((o1, o2) -> distance.get(o2).compareTo(distance.get(o1)));
        
        
        int i = numlist.length - 1;
        for (Integer key : keySet) {
            answer[i] = key;
            i--;
        }
        
        return answer;
    }
}
