import java.util.Queue;
import java.util.LinkedList;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> cards = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {	// 큐에 카드 삽입
			cards.offer(i);
		}
		
		while(cards.size() > 1) {
			cards.poll();	// 맨 앞의 원소 버림
			cards.offer(cards.poll());	// 그 다음 맨 앞의 원소를 꺼내 맨 뒤에 삽입 
		}
		
		System.out.println(cards.poll());	// 마지막으로 남은 원소 출력 
	}
}