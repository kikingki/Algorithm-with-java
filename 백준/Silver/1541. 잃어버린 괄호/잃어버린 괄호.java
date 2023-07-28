import java.util.*;

public class Main {
    static int answer = 0;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        String str = sc.nextLine();
        String[] expressions = str.split("-");
        
        for(int i=0; i<expressions.length; i++) {
            int temp = mySum(expressions[i]);
            // 첫번째 데이터면 결괏값을 더하기
            if(i == 0) answer += temp;
            else answer -= temp;
        }
        
        System.out.println(answer);
    }
    
    private static int mySum(String expression) {
        String[] sumList = expression.split("[+]");
        int sum = 0;
        
        for(String n : sumList) {
            sum += Integer.parseInt(n);
        }
        return sum;
    }
}