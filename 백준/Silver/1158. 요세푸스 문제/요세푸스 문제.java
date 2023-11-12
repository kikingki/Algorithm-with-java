import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // StringBuilder로 String Build 후 출력
        StringBuilder answer = new StringBuilder();
        answer.append("<");

        Queue deque = new LinkedList<>();

        for(int i=1; i<=N; i++) {
            deque.add(i);
        }

        int cnt = 0;

        // k번째 수를 출력하고, k번째 수를 제거
        while(!deque.isEmpty()) {
            cnt++;
            int num = (int) deque.poll();
            
            if(cnt != K) {
                deque.add(num);

            } else {    
                cnt = 0;
                answer.append(num).append(", ");
            }
        }
        
        // 마지막에 ", "를 제거하고 ">"를 추가
        answer.delete(answer.length()-2, answer.length());
        answer.append(">");

        System.out.println(answer);
    }
}
