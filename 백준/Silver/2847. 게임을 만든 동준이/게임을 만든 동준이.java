import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] level = new int[N];

        for(int i=0; i<N; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for(int i=N-1; i>0; i--) {
            int highLevel = level[i];
            int lowLevel = level[i-1];
            
            if(highLevel <= lowLevel) {
                int diffScore = (lowLevel + 1) - highLevel;     // 감소시켜야 하는 점수
                answer += diffScore;
                level[i-1] = highLevel - 1;                 // 이전 레벨은 딱 1민큼만 더 낮으면 됨
            }
        }

        System.out.println(answer);
    }
}
