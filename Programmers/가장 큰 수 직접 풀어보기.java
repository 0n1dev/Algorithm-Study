import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        String result = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o2+o1).compareTo((o1+o2)))
                .collect(Collectors.joining());

        if (result.charAt(0) == '0') return "0";
        
        return result;
    }
}