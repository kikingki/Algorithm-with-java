import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Member implements Comparable<Member> {
    int age;
    String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Member m) {
        return this.age - m.age;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Member> members = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            members.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Collections.sort(members);

        StringBuilder sb = new StringBuilder();

        for(Member member : members) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }

        System.out.println(sb);
    }
}