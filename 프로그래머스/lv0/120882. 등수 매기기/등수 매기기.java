class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        double[] average = new double[score.length];
        
        for(int i = 0; i<score.length; i++) {
            average[i] = ((double)score[i][0] + score[i][1]) / 2;
            answer[i] = 1;
        }
        
        for(int i = 0; i<score.length; i++) {
            for(int j = 0; j<score.length; j++) {
                if(average[i] < average[j]) answer[i]++;
            }
        }
        
        return answer;
    }
}