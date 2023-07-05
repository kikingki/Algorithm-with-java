import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 정렬기준 정의
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i=0; i<N; i++) {
            int x = Integer.parseInt(br.readLine());
            // x가 0일 때
            if(x == 0) {
                if(queue.isEmpty()) { 
                    System.out.println("0"); 
                } else System.out.println(queue.poll());
            } else queue.add(x);    // x가 0이 아닐 때
        }
    }
}