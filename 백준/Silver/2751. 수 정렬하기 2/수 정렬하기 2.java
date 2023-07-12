import java.util.*;
import java.io.*;

public class Main {
    public static int[] arr, temp;
    public static long result;
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];       // 결과 배열
        temp = new int[N];      // 정렬에 사용할 임시 배열
        
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        merge(0, N-1);
        
        for(int i=0; i<N; i++) {
            bw.write(arr[i] + "\n");
        }
        
        bw.flush();
        bw.close();
    }
    
    public static void merge(int start, int end) {
        // 재귀 함수
        if(end-start < 1) return ;  // 데이터 집합의 개수가 1개일 때
        
        int mid = start + (end - start) / 2;
        merge(start, mid);
        merge(mid+1, end);
        
        for(int i=start; i<=end; i++) {
            temp[i] = arr[i];
        }
        
        int k = start;
        int index1 = start;
        int index2 = mid + 1;
        
        // 두 데이터 집합을 병합
        while(index1 <= mid && index2 <= end) {
            if(temp[index1] > temp[index2]) {
                arr[k] = temp[index2++];
                k++;
            } else { 
                arr[k] = temp[index1++];
                k++;
            }
        }
        
        // 한쪽 그룹이 모두 선택된 후 남아 있는 값 정리
        while(index1 <= mid) {
            arr[k] = temp[index1++];
            k++;
        }
        
        while(index2 <= end) {
            arr[k] = temp[index2++];
            k++;
        }
    }
}