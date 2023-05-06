import java.util.*;

class Solution {
    public String solution(String s) {
        String[] numbers = s.split(" ");
        int[] intNumbers = new int[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            intNumbers[i] = Integer.parseInt(numbers[i]);
        }
        
        Arrays.sort(intNumbers);
        
        return intNumbers[0] + " " + intNumbers[numbers.length-1];
    }
}