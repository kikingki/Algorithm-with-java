import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        
        // 주어지는 수열
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        
        // 1부터 n까지의 수를 오름차순으로 넣을 스택
        Stack<Integer> stack = new Stack<>();
        int num = 1;        // 오름차순 자연수
        StringBuffer bf = new StringBuffer();
        Boolean result = true;
        
        for(int i=0; i<A.length; i++) {
            int su = A[i];  // 현재 수열의 값
            if(su >= num) {
                // 현재 수열의 값과 같아질 때까지 push
                while(su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                // 같아지면 pop
                stack.pop();
                bf.append("-\n");
            } else {
                int n = stack.pop();
                // 스택의 마지막 값이 su보다 크면 불가능
                if(n > su) { 
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else {
                    bf.append("-\n");
                }
            }
        }
        
        // 스택 수열을 만들 수 있으면 연산 결과 출력
        if(result) {
            System.out.println(bf.toString());
        }
    }
}