import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();     // HashMap: 조회 속도가 빠름

        for(int i=0; i<N; i++) {
            map.put(st.nextToken(), 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // StringBuilder로 출력 시간 단축
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            if(map.containsKey(st.nextToken())) sb.append("1 ");
            else sb.append("0 ");
        }
        System.out.println(sb);
    }
}
