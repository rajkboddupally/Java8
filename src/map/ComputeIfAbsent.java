package map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ComputeIfAbsent {
    private static Map<Integer, Integer> myMap = new ConcurrentHashMap<>();

    static {
        myMap.put(0, 1);
        myMap.put(1, 1);
    }

    public static void main(String[] args) {


        Map<String, Integer> myMap1 = new HashMap<>();

        myMap1.computeIfAbsent("hello", k -> 2);
        myMap1.computeIfAbsent("hello", k -> 3);
        myMap1.computeIfAbsent("hello2", k -> 4);

        //System.out.println(myMap1.get("hello"));

        int output = fibo(5);
        System.out.println(output);
    }

    private static int fibo(int n) {
        return myMap.computeIfAbsent(n, k -> fibo(k - 1) + fibo(k - 2));
    }


    private static Integer f(String k) {
        System.out.println(k);
        return 0;
    }
}
