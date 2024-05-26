import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
다솜이의 득표수를 1점씩 올리고 다른 후보자들과 비교 - N번
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int dasom = Integer.parseInt(st.nextToken());
        int cnt = 0;

        // 혼자만 후보일 때
        if(N==1)  {
            System.out.println(cnt);
            return;
        }

        Integer[] nominee = new Integer[N-1];
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            nominee[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nominee, Collections.reverseOrder());

        // 가장 높은 점수를 가진 후보가 다솜이보다 점수가 높거나 같을 경우
        while (nominee[0] >= dasom) {
            dasom++;
            nominee[0]--;
            cnt++;
            Arrays.sort(nominee, Collections.reverseOrder());
        }

        System.out.println(cnt);
    }
}
