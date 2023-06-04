import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public int solution(String before, String after) {
        before = Stream.of(before.split(""))
                    .sorted()
                    .collect(Collectors.joining());
        
        after = Stream.of(after.split(""))
                    .sorted()
                    .collect(Collectors.joining());
        
        if(before.equals(after)) return 1;
        else return 0;
    }
}