import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        char[][] digit = settingDigit();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = new String[] {"", "", "", ""};

        // 시계의 각 자리별로 한줄씩 입력
        for(int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String hour1 = st.nextToken();
            String hour2 = st.nextToken();
            String minute1 = st.nextToken();
            String minute2 = st.nextToken();
            input[0] += hour1;
            input[1] += hour2;
            input[2] += minute1;
            input[3] += minute2;
        }

        char[][] brokenClock = new char[4][15];
        for(int i=0; i<4; i++) {
            brokenClock[i] = input[i].toCharArray();        // 각 문자마다 비교를 위해 char 배열로 변경
        }

        StringBuilder answer = new StringBuilder();

        int j, k;
        for(int i=0; i<4; i++) {
            if (i==2) answer.append(":");
            for(j=0; j<10; j++) {
                for (k=0; k<15; k++) {
                    // 조건: 켜지지 않아야 하는 발광 다이오드가 켜진 경우는 없다.
                    // 입력된 발광 다이오드는 켜져있고, 숫자의 발광 다이오드는 꺼져있는 경우 해당 숫자가 아님
                    if (brokenClock[i][k] == '#' && digit[j][k] == '.') {
                        break;
                    }
                }
                // 중간에 break로 넘어가지 않고, 15칸을 다 통과할 경우의 최소 숫자
                if(k==15) {
                    answer.append(j);
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    private static char[][] settingDigit() {
        char[] zero =  "####.##.##.####".toCharArray();
        char[] one =   "..#..#..#..#..#".toCharArray();
        char[] two =   "###..#####..###".toCharArray();
        char[] three = "###..####..####".toCharArray();
        char[] four =  "#.##.####..#..#".toCharArray();
        char[] five =  "####..###..####".toCharArray();
        char[] six =   "####..####.####".toCharArray();
        char[] seven = "###..#..#..#..#".toCharArray();
        char[] eight = "####.#####.####".toCharArray();
        char[] nine =  "####.####..####".toCharArray();

        return new char[][]{ zero, one, two, three, four, five, six, seven, eight, nine };
    }
}
