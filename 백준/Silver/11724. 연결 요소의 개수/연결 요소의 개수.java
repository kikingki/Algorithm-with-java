import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        for(int i=1; i<=N; i++) {
            parents[i] = i;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(find(u) != find(v)) union(u,v);
        }

        for(int i=1; i<=N; i++) {
            find(i);
        }

        // 그룹 방문 여부
        boolean[] check = new boolean[N+1];
        int ans = 0;

        for(int i=1; i<=N; i++) {
            int group = parents[i];
            if(!check[group]) {
                ans++;
                check[group] = true;
            }
        }

        System.out.println(ans);
    }

    public static int find(int a) {
        if(a == parents[a]){
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa == pb){
            return;
        }

        if(pa <= pb) {
            parents[pb] = pa;
        }else {
            parents[pa] = pb;
        }
    }
}
