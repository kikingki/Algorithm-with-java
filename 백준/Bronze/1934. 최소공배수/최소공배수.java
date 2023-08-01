import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int lcm = (a*b)/gcd(a,b);
            System.out.println(lcm);
        }
    }

    static int gcd(int a, int b) {
        if(a%b == 0) return b;
        else {
            int tmp = a;
            a = b;
            b = tmp%b;
            return gcd(a, b);
        }
    }
}
