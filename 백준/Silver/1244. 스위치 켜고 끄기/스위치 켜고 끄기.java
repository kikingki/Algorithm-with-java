import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] switchStatus;      
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchNum = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        switchStatus = new boolean[switchNum+1];

        // 정보 입력
        for(int i=1; i<=switchNum; i++) {
            switchStatus[i] = Integer.parseInt(st.nextToken()) != 0;
        }

        int count = Integer.parseInt(br.readLine());
        
        for(int i=0; i<count; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(gender == 1) {
                male(num);
            } else {
                female(num);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=switchNum; i++) {
            if (switchStatus[i]) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }

            if(i%20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    // 남 : 자기가 받은 수의 배수 번호 스위치 = !스위치 상태
    private static void male(int num) {
        for(int i = num; i<switchStatus.length; i+=num) {
            switchStatus[i] = !switchStatus[i];
        }
    }

    /* 여 : 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태를 모두 변경
     => 대칭이 아닐때까지 상태 변경 */
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
