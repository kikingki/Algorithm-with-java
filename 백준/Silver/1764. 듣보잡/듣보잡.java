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
        int cnt = 0;        // 듣보잡의 수

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++) {
            map.put(br.readLine(), 1);
        }

        for(int i=N; i<N+M; i++) {
            String name = br.readLine();

            if(map.containsKey(name)) {
                map.put(name, map.get(name)+1);
                cnt++;
            } else {
                map.put(name, 1);
            }
        }

        // 키 값으로 오름차순 정렬
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        System.out.println(cnt);

        for(String key : keySet) {
            if(map.get(key) > 1) System.out.println(key);
        }
    }
}