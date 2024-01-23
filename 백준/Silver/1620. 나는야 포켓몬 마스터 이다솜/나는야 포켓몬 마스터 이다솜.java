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
            if(isNumberic(question)) sb.append(map1.get(Integer.parseInt(question))).append("\n");
            else sb.append(map2.get(question)).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean isNumberic(String str) {
        return str.chars().allMatch(Character::isDigit);
    }
}
