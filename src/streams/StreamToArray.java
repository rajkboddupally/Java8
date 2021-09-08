package streams;

/* Raj Kumar Boddupally created on 9/8/2021 inside the package - streams */

import java.util.stream.Stream;

public class StreamToArray {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("one", "two", "three");
        Stream<String> stringStream1 = Stream.of("1", "2", "3");
        Stream<Integer> intStream1 = Stream.of(1, 2, 3);

        Object[] objectArray = stringStream.toArray();

        //Method 1 - LAMBDA
        String[] stringArray = stringStream.toArray(size -> new String[size]);

        //Method 2 - Constructor reference
        String[] stringArray1 = stringStream.toArray(String[]::new);

        //Method 3 - ParseInt
        int[] integerArray1 = stringStream1.mapToInt(Integer::parseInt).toArray();

        int[] integerArray2 = intStream1.mapToInt(x -> x).toArray();


    }
}
