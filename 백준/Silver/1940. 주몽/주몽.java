import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        // 한 줄 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++) {
            // 공백을 기준으로 토큰을 나눔
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        
        int i = 0;
        int j = N-1;
        int count = 0;
        
        // 투 포인터 실행
        while(i < j) {
            if(A[i]+A[j] < M) i++;
            else if (A[i]+A[j] > M) j--;
            else {
                count++; 
                i++; j--;
            }
        }
        
        System.out.println(count);
	}
}
