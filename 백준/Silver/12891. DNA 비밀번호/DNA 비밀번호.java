import java.util.*;
import java.io.*;

public class Main {
    static int myArr[];
    static int checkArr[];
    static int checkSecret;

	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Result = 0;
        myArr = new int[4];   // 현재 상태
        checkArr = new int[4];    // 비밀번호 체크
        char A[] = new char[S]; // 전체 문자열 데이터
        checkSecret = 0; // 몇 개의 문자 개수를 충족했는지 판단하는 변수 -> 4가 되면 Result++
        
        A = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0) { 
                checkSecret++; 
            }
        }
        
        // 부분문자열 처음 받을 때 세팅
        for(int i=0; i<P; i++) {
            Add(A[i]);
        }

        if(checkSecret == 4) Result++;
        
        // 슬라이딩 윈도우
        // j = 부분문자열 제일 왼쪽, i = 부분문자열 제일 오른쪽
        for(int i=P; i<S; i++) {
            int j = i-P;
            Add(A[i]);
            Remove(A[j]);
            if(checkSecret == 4) Result++;
        }
        
        System.out.println(Result);
        bf.close();
	}
    
    private static void Add(char c) {
        switch(c) {
            case 'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }
        
            private static void Remove(char c) {
        switch(c) {
            case 'A':
                if(myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }
}