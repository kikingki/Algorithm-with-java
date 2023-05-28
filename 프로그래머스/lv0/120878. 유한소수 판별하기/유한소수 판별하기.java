class Solution {
    public int gcd(int a, int b){   // 유클리드호제법
        if(b == 0) {
            return a;
        }else{
            return gcd(b, a%b);
        }
    }
    
    public int solution(int a, int b) {
        int denom = b/gcd(a,b);   // 기약분수의 분모
        
        while(denom != 1) {
            if(denom % 2 == 0) denom /= 2;
            else if(denom % 5 == 0) denom /= 5;
            else return 2;
        }
        return 1;
    }
}