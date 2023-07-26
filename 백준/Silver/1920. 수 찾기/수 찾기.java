import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        // 이진 탐색
        for(int i=0; i<M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int result = 0;
            
            int start = 0;
            int end = arr.length-1;
            
            while(start <= end) {
                int mid = (start+end) / 2;
                if (arr[mid] < target) {
                    start = mid+1;
                }
                else if(arr[mid] > target){ 
                    end = mid-1;
                }
                else {
                    result = 1;
                    break;
                }
            }
            System.out.println(result);
        }
    }
}