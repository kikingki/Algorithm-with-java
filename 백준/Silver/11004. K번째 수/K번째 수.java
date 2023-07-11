import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        quickSort(A, 0, N-1, K-1);
        System.out.println(A[K-1]);        
    }
    
    public static void quickSort(int[] A, int start, int end, int K) {
        if(start < end) {
        int pivot = partition(A, start, end);
        
        if(pivot == K) return ;
        else if(K < pivot) quickSort(A, start, pivot-1, K);
        else quickSort(A, pivot+1, end, K);
        }
    }
    
    public static int partition(int[] A, int start, int end) {
        if(start+1 == end) {
            if(A[start] > A[end]) swap(A, start, end);
            return end;                 
            }
        
            int mid = (start + end) / 2;
            swap(A, start, mid);        // 중앙값을 1번째 요소로 이동
            
            int pivot = A[start];
            int i = start+1;
            int j = end;
            
            while(i <= j) {
                while(pivot > A[i] && i < A.length-1) i++; 
                while (pivot < A[j] && j > 0) j--; 
                if(i <= j) swap(A, i++, j--);   // start, end를 swap하고 start는 오른쪽, end는 왼쪽으로 1칸씩 이동
            }

            // i == j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정
            A[start] = A[j];
            A[j] = pivot;
            return j;
    }
    
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}