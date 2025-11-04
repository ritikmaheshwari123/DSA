package TelusAssessment;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class NumberFrequencyInString {
    public static void main(String[] args) {
        String qaz = "1,2,3,4,5,6,6,7,1,5,5,5";
        Map<String,Long> numberCounts = Arrays.stream(qaz.split(","))
                .map(String::trim)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        numberCounts.forEach((num,count)-> System.out.println(num + ":" + count));
    }
}
