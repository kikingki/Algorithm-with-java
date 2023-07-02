import java.util.*;

public class Main {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;  // 자기자신 하나로 이루어진 경우의 수 미리 저장
        int start_index = 1;
        int end_index = 1;
        int sum = 1;
        
        while(end_index != N) {
            if(sum == N) {
                count++;
                // end_index 확장 후 더하기
                end_index++; sum += end_index;
            } else if (sum > N) {
                // 기존 값 빼고 한 칸 이동
                sum -= start_index; start_index++;
            } else {
                end_index++; sum += end_index;
            }
        }
        
        System.out.println(count);
	}
}