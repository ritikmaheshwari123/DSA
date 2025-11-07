package TelusAssessment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class NumberFrequencyInString {
    public static void main(String[] args) {
        String qaz = "1,2,3,4,5,6,6,7,1,5,5,5";
        withoutStream(qaz);

    }

    public void withStream(String str){
        Map<String,Long> numberCounts = Arrays.stream(str.split(","))
                .map(String::trim)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        numberCounts.forEach((num,count)-> System.out.println(num + ":" + count));
    }

    public static void withoutStream(String str){
        String[] numbers = str.split(",");

        // Use a HashMap to store frequency
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Print frequencies
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("Number " + entry.getKey() + " -> " + entry.getValue() + " times");
        }
    }
}
