class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];           // 등수
        double[] average = new double[score.length];    // 평균(소수점 포함하기 위해 double 배열)
        
        for(int i = 0; i<score.length; i++) {
            average[i] = ((double)score[i][0] + score[i][1]) / 2;
            answer[i] = 1;
        }
        
        // 점수가 더 낮을 경우에 등수를 하나씩 낮춤
        for(int i = 0; i<score.length; i++) {
            for(int j = 0; j<score.length; j++) {
                if(average[i] < average[j]) answer[i]++;
            }
        }
        
        return answer;
    }
}