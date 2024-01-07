import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tall = new int[n+1];

        for(int i=1; i<=n; i++) {
            tall[i] = sc.nextInt();
        }

        List<Integer> line = new ArrayList<>();
        // 키가 큰 사람부터 줄을 서면, "왼쪽에 있는 자기보다 키 큰 사람의 수+1=자기가 줄을 서게 될 위치"의 규칙이 있다.
        for(int i=n; i>=1; i--) {
            line.add(tall[i], i);       // 키가 i인 사람을 인덱스 tall[i]번째에 삽입
        }

        for(int k : line) {
            System.out.print(k+" ");
        }
    }
}
