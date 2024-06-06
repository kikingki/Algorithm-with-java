import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[st.countTokens()];
            
            for(int j=0; j<arr.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(arr);
            int max = 0;
            
            for(int j=0; j<arr.length-1; j++) {
                for(int k=j+1; k<arr.length; k++) {
                    int temp = gcd(arr[k], arr[j]);
                    if(temp > max) max = temp;
                }
            }
            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
    
    private static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}
