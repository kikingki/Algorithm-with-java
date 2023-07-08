import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] A = new int[str.length()];
        
        for(int i=0; i<str.length(); i++) {
            // 한글자씩 저장
            A[i] = Integer.parseInt(str.substring(i, i+1));
        }
        
        // N의 각 자릿수를 내림차순 정렬하는 것이므로 N은 최대여도 10개
        // 선택 정렬
        for(int i = 0; i<str.length(); i++) {
            int max = i;
            for(int j=i+1; j<str.length(); j++) {
                if(A[j] > A[max]) max = j;
            } 
            // 현재 i의 값과 max 값 비교
            if(A[i] < A[max]) {
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }
        }
        
        for(int i=0; i<str.length(); i++) {
            System.out.print(A[i]);
        }
    }
}