import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting> {
    int start, end;

    public Meeting (int start, int end) {
        this.start = start;
        this.end = end;
    }

    // 종료 시간 오름차순으로 정렬하고, 종료 시간이 같다면 시작 시간 오름차순 정렬
    @Override
    public int compareTo(Meeting m) {
        if(this.end == m.end) return this.start - m.end;
        return this.end - m.end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int count = 0;      // 회의 배정 개수

        ArrayList<Meeting> arr = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr.add(new Meeting(start, end));
        }

        Collections.sort(arr);

        int currentEnd = 0;  // 배정된 회의 종료 시간

        for(int i=0; i<N; i++) {
            Meeting next = arr.get(i);

            // 다음 회의 시작 시간이 배정된 회의 종료 시간보다 크거나 같다면 currentEnd 갱신
            if (next.start >= currentEnd) {
                count++;
                currentEnd = next.end;
            }
        }

        System.out.println(count);
    }
}
