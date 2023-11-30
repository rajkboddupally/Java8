package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMapExample {
    public static void main(String[] args) {
        List<String> input = List.of("one", "two-two", "three","two");
        Map<String, Integer> outputMap = input.stream().collect(Collectors.toMap(str->str, String::length, (oldvalue, newvalue) -> newvalue));
        outputMap.forEach((k,v) -> System.out.println(k + " - "+v));
        System.out.println( "*****************");
        List<String> sortedList = input.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
        sortedList.forEach(System.out::println);
    }
}
