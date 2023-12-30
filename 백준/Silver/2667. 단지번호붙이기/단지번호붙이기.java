import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n; // 지도의 크기
    static int[][] home; // N x N의 2차원 배열 지도
    static int cnt; // 각 단지의 집의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 지도의 크기
        home = new int[n][n]; // N x N의 2차원 배열 지도

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                home[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> count = new ArrayList<>(); // 각 단지의 집의 수를 저장하는 배열
        cnt = 0; // 각 단지의 집의 수 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 한 단지를 탐색한 후 cnt 초기화
                if (dfs(i, j)) {
                    count.add(cnt);
                    cnt = 0;
                }
            }
        }

        Collections.sort(count); // 오름차순
        // 총 단지 수와 각 단지내 집의 수 출력
        System.out.println(count.size());
        for (int c : count) {
            System.out.println(c);
        }
    }

    static boolean dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) { // 범위 체크
            return false;
        }

        if (home[x][y] == 1) {
            cnt++;
            home[x][y] = 0; // 방문한 노드 다시 방문X

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                dfs(nx, ny);        // 재귀 호출
            }
            return true;
        }
        return false;
    }
}