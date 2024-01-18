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
        HashMap<String, Integer> map = new HashMap<>();     

        for(int i=0; i<N; i++) {
            String card = st.nextToken();
            if(map.containsKey(card)) map.put(card, map.get(card)+1);
            else map.put(card, 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            String card = st.nextToken();
            if(map.containsKey(card)) sb.append(map.get(card)).append(" ");
            else sb.append("0 ");
        }
        System.out.println(sb);
    }
}
