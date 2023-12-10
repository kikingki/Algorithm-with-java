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
        int cnt = 0;

        HashSet<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            set.add(br.readLine());
        }

        for(int i=N; i<N+M; i++) {
            String name = br.readLine();

            if(set.contains(name)) {     // 듣보잡이면 리스트에 추가
                cnt++;
                list.add(name);
            }
        }

        Collections.sort(list);     // 오름차순 정렬

        // StringBuilder로 출력 시간 단축
        System.out.println(cnt);
        StringBuilder sb = new StringBuilder();
        for(String name : list) {
            sb.append(name).append("\n");
        }
        System.out.println(sb);
    }
}
