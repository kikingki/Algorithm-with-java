import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class MeetingRoom implements Comparable<MeetingRoom> {
        int startTime;
        int endTime;

        public MeetingRoom(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(MeetingRoom m) {
            // 종료 시간이 같을 경우 시작 시간이 빠른순으로 정렬
            if(this.endTime == m.endTime) return this.startTime - m.startTime;
            return this.endTime - m.endTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<MeetingRoom> meetingRoomList = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meetingRoomList.add(new MeetingRoom(s, e));
        }

        Collections.sort(meetingRoomList);

        int cnt = 0;
        int currentEnd = 0;
        for(int i=0; i<N; i++) {
            MeetingRoom next = meetingRoomList.get(i);
            if(currentEnd <= next.startTime) {
                currentEnd = next.endTime;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
