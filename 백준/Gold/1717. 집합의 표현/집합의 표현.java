import java.util.*;
import java.io.*;

public class Main {   
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];    // 0 <= a,b <= n

        // 대표 노드를 자기 자신으로 초기화
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        // 연산 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cal = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cal == 0) {     // 합집합 연산
                union(a, b);
            } else {            // 같은 집합인지 확인
                boolean flag = checkSame(a, b);
                if (flag) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    private static void union(int a, int b) {
        // a,b의 대표 노드
        a = find(a);
        b = find(b);

        if (a != b) {   // a와 b의 대표 노드가 다르다면
            parent[b] = a;  // b의 대표 노드를 a로 갱신
        }
    }

    // find 함수를 재귀적으로 호출하면서 대표노드를 찾고 경로 압축
    private static int find(int a) {
        if (a == parent[a]) return a;   // 자기 자신이 대표 노드라면
        else {
            // value를 index로 하여 재귀적으로 호출 + 재귀를 나올 때마다 갱신 (경로 압축)
            return parent[a] = find(parent[a]);
        }
    }

    // 두 노드의 대표 노드가 같은지 확인
    private static boolean checkSame(int a, int b) {
        if(find(a) == find(b)) return true;
        return false;
    }
}