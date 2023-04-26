class Solution {
    public String solution(String polynomial) {
        int xNum = 0; 
        int num = 0;

        for (String s : polynomial.split("\\+")) {
            s = s.trim();
            // 1차항
            if (s.contains("x")) xNum += s.equals("x") ? 1 : Integer.parseInt(s.replaceAll("x", ""));
            // 상수항
            else num += Integer.parseInt(s);
        }
        
        // 계수 1은 생략
        return (xNum != 0 ? (xNum > 1 ? xNum + "x" : "x") : "") 
        		+ (num != 0 ? (xNum != 0 ? " + " : "") + num : xNum == 0 ? "0" : "");
    }
}

// 삼항연산자를 능숙하게 응용해야 함