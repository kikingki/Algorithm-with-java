import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(int i=1; i<=N; i++) {
            String pokemon = br.readLine();
            map1.put(i, pokemon);
            map2.put(pokemon, i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            String question = br.readLine();
            // 모든 문자를 확인할 필요없이, 첫 글자만 숫자인지 판별하면 됨
            if(question.charAt(0) <= '9') {
                sb.append(map1.get(Integer.parseInt(question))).append("\n");
            }
            else sb.append(map2.get(question)).append("\n");
        }
        System.out.println(sb);
    }
}
