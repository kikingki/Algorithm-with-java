import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] ropes = new int[N];

        for(int i=0; i<N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);

        int answer = ropes[N-1];
        for(int i=N-1; i>=0; i--) {
            answer = Math.max(answer, ropes[i] * (N-i));
        }

        System.out.println(answer);
    }
}
