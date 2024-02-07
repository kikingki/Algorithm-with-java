import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] switchStatus;      // 스위치 상태
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchNum = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        switchStatus = new boolean[switchNum+1];

        // 스위치 정보 입력
        for(int i=1; i<=switchNum; i++) {
            switchStatus[i] = Integer.parseInt(st.nextToken()) != 0;
        }

        int count = Integer.parseInt(br.readLine());

        // 스위치 상태 변경
        for(int i=0; i<count; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(gender == 1) {
                // 남학생 함수
                male(num);
            } else {
                // 여학생 함수
                female(num);
            }
        }

        StringBuilder sb = new StringBuilder();
        // 스위치 출력
        for(int i=1; i<=switchNum; i++) {
            if (switchStatus[i]) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }

            if(i%20 == 0) {
                sb.deleteCharAt(sb.length() - 1);
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    // 남 1: 자기가 받은 수의 배수 번호 스위치 = !스위치 상태
    private static void male(int num) {
        for(int i = num; i<switchStatus.length; i+=num) {
            switchStatus[i] = !switchStatus[i];
        }
    }

    /* 여 2: 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서(스위치 상태가 같음) 가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태를 모두 바꾼다. => 투포인터..?
     이 때 구간에 속한 스위치 개수는 항상 홀수가 된다. (=대칭 스위치+받은 스위치) */
    private static void female(int num) {
        switchStatus[num] = !switchStatus[num];
        int startIdx = num-1;
        int endIdx = num+1;

         while (startIdx>0 && endIdx<switchStatus.length){
            if(switchStatus[startIdx] == switchStatus[endIdx]) {
                switchStatus[startIdx] = !switchStatus[startIdx];
                switchStatus[endIdx] = !switchStatus[endIdx];

                startIdx--;
                endIdx++;
            } else break;
        }
    }
}
