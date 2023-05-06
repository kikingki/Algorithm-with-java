import java.util.*;

class Solution {
    public String solution(String s) {
        String[] numbers = s.split(" ");
        int[] iNumbers = new int[numbers.length];
        int iMax    = Integer.MIN_VALUE;
        int iMin    = Integer.MAX_VALUE;
        
        for(int i=0; i<numbers.length; i++) {
            iNumbers[i] = Integer.parseInt(numbers[i]);
        }
        
        //최대값 구하기
        for(int i : iNumbers)  iMax = Math.max( i, iMax );

        //최소값 구하기
        for(int i : iNumbers)  iMin = Math.min( i, iMin );
        
        return iMin + " " + iMax;
    }
}